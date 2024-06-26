package org.pbl.expression;

import org.pbl.util.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {

    List<Expression> list;

    public Map<String, Object> values; // symbol table for variables and their values

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {

        List<String> evaluations = new ArrayList<>();

        for (Expression e : list) {


            if (e instanceof VariableDeclaration) {

                VariableDeclaration vd = (VariableDeclaration) e;

                Object value = getEvalResult(vd.value);

                values.put(vd.id, value);
            } else if (e instanceof FunctionCall) {

                FunctionCall fc = (FunctionCall) e;
                String id = fc.id;
                List<Expression> values = fc.value;
                Object extractedValue;

                switch (id) {
                    case "tva":
                        extractedValue = getEvalResult(values.get(0));
                        evaluations.add("Value " + extractedValue + " has TVA: " + (Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.tvaJuridic)));
                        break;
                    case "print":
                        extractedValue = getEvalResult(values.get(0));
                        if (extractedValue instanceof String) {
                            evaluations.add(extractedValue + "");
                        } else if (values.get(0) instanceof Variable) {
                            evaluations.add(values.get(0) + " = " + extractedValue);
                        } else if (extractedValue instanceof Double || extractedValue instanceof Integer) {
                            evaluations.add(extractedValue + "");
                        }
                        break;
                    case "impozitulPeVenit":
                        extractedValue = getEvalResult(values.get(0));
                        if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                            evaluations.add("Impozitul pe venit: " + (Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitulPeVenitPhysic)) + ", remaining sum: " + (Double.parseDouble(extractedValue + "") * (1 - Double.parseDouble(Util.impozitulPeVenitPhysic))));
                        else if (AntlrToExpression.getUserMode() == UserMode.JURIDIC)
                            evaluations.add("Impozitul pe venit: " + (Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitulPeVenitJuridic)) + ", remaining sum: " + (Double.parseDouble(extractedValue + "") * (1 - Double.parseDouble(Util.impozitulPeVenitJuridic))));
                        break;
                    default:
                        evaluations.add("Function " + id + " not found");
                }
            } else if (e instanceof IfExpression) {

                IfExpression ie = (IfExpression) e;
                evaluations.add(getEvalResult(ie) + "");

            } else if (e instanceof WhileExpression) {

                WhileExpression we = (WhileExpression) e;
                List<Expression> body = we.getBodyExpressions();
                whileMethodSkeleton(evaluations, body, we);

            } else if (e instanceof ForExpression) {

                ForExpression fe = (ForExpression) e;

                String id = fe.getId();

                if (!values.containsKey(id)) {
                    values.put(id, 0);
                }

                Expression baseValue = fe.getBaseValue();
                Expression endValue = fe.getEndValue();
                Expression step = fe.getStep();
                Object end = getEvalResult(endValue);
                List<Expression> body = fe.getBodyExpressions();

                if (fe.hasAssignment()) {
                    baseValue = new Assignment(id, baseValue);
                    values.put(id, getEvalResult(baseValue));
                }

                if (fe.hasStep()) {
                    body.add(new Assignment(id, new Addition(new Variable(id), step)));
                } else {
                    body.add(new Assignment(id, new Addition(new Variable(id), new Number(1))));
                }

                int i = (Integer) end;

                WhileExpression we = new WhileExpression(new RelationalComparison(new Variable(id), Relational.LESS_THAN, new Number(i)), body);

                body = we.getBodyExpressions();
                whileMethodSkeleton(evaluations, body, we);

            } else if (e instanceof Assignment) {

                Assignment a = (Assignment) e;
                String id = a.getId();
                Expression expressionValue = a.getExpressionValue();
                Object value = getEvalResult(expressionValue);
                values.put(id, value);

            } else if (e instanceof Number || e instanceof Variable || e instanceof Addition || e instanceof Multiplication || e instanceof Division || e instanceof Subtraction) { // Number or Variable or Addition or Multiplication or Division or Subtraction
                String input = e.toString();

                Object result = getEvalResult(e);
                evaluations.add(input + " is " + result);
            }
        }

        return evaluations;
    }

    private void whileMethodSkeleton(List<String> evaluations, List<Expression> body, WhileExpression we) {
        Expression condition = we.getCondition();

        while ((Boolean) getEvalResult(condition)) {

            for (Expression expression : body) {

                if (expression instanceof FunctionCall) {
                    expression = new FunctionCall(((FunctionCall) expression).id, ((FunctionCall) expression).value);
                    if (((FunctionCall) expression).id.equals("print")) {
                        evaluations.add(getEvalResult(expression) + "");
                    }
                } else
                    getEvalResult(expression);
            }
        }
    }

    private Object getEvalResult(Expression e) {

        if (e instanceof Number) {
            Number n = (Number) e;
            return n.num;
        } else if (e instanceof Variable) {
            Variable v = (Variable) e;

            return values.get(v.id); // variable value from symbol table
        } else if (e instanceof Addition) {
            Addition a = (Addition) e;
            Object left = getEvalResult(a.left);
            Object right = getEvalResult(a.right);
            if (left instanceof Double && right instanceof Double) {
                double result = (Double) left + (Double) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Double) {
                double result = (Integer) left + (Double) right;
                return round(result, 4);
            } else if (left instanceof Double && right instanceof Integer) {
                double result = (Double) left + (Integer) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Integer) {
                double result = (Integer) left + (Integer) right;
                return round(result, 4);
            } else if (left instanceof String) {
                return (String) left + right;
            } else if (right instanceof String) {
                return left + (String) right;
            } else {
                throw new IllegalArgumentException("Invalid operation: cannot add non-numeric values");
            }

        } else if (e instanceof Subtraction) {
            Subtraction s = (Subtraction) e;
            Object left = getEvalResult(s.left);
            Object right = getEvalResult(s.right);
            if (left instanceof Double && right instanceof Double) {
                double result = (Double) left - (Double) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Double) {
                double result = (Integer) left - (Double) right;
                return round(result, 4);
            } else if (left instanceof Double && right instanceof Integer) {
                double result = (Double) left - (Integer) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Integer) {
                double result = (Integer) left - (Integer) right;
                return round(result, 4);
            } else {
                throw new IllegalArgumentException("Invalid operation: cannot add non-numeric values");
            }
        } else if (e instanceof Multiplication) {
            Multiplication m = (Multiplication) e;
            Object left = getEvalResult(m.left);
            Object right = getEvalResult(m.right);
            if (left instanceof Double && right instanceof Double) {
                double result = (Double) left * (Double) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Double) {
                double result = (Integer) left * (Double) right;
                return round(result, 4);
            } else if (left instanceof Double && right instanceof Integer) {
                double result = (Double) left * (Integer) right;
                return round(result, 4);
            } else if (left instanceof Integer && right instanceof Integer) {
                double result = (Integer) left * (Integer) right;
                return round(result, 4);
            } else {
                throw new IllegalArgumentException("Invalid operation: cannot multiply non-numeric values");
            }
        } else if (e instanceof Division) {
            Division d = (Division) e;
            Object left = getEvalResult(d.left);
            Object right = getEvalResult(d.right);
            if (left instanceof Double && right instanceof Double) {
                return (Double) left / (Double) right;
            } else {
                throw new IllegalArgumentException("Invalid operation: cannot divide non-numeric values");
            }
        } else if (e instanceof BooleanExpression) {
            BooleanExpression b = (BooleanExpression) e;
            return b.bool;
        } else if (e instanceof EqualityComparison) {
            EqualityComparison ec = (EqualityComparison) e;
            Object left = getEvalResult(ec.left);
            Object right = getEvalResult(ec.right);
            if (left.equals(right)) {
                return true;
            } else {
                return false;
            }
        } else if (e instanceof RelationalComparison) {

            RelationalComparison rc = (RelationalComparison) e;
            Object left = getEvalResult(rc.left);
            Object right = getEvalResult(rc.right);

            if (left instanceof java.lang.Number && right instanceof java.lang.Number) {
                double leftVal = ((java.lang.Number) left).doubleValue();
                double rightVal = ((java.lang.Number) right).doubleValue();
                switch (rc.relational) {
                    case LESS_THAN:
                        return leftVal < rightVal;
                    case GREATER_THAN:
                        return leftVal > rightVal;
                    case LESS_THAN_OR_EQUAL:
                        return leftVal <= rightVal;
                    case GREATER_THAN_OR_EQUAL:
                        return leftVal >= rightVal;
                }
            } else {

                throw new IllegalArgumentException("Invalid operation: cannot compare non-numeric values");
            }
        } else if (e instanceof StringExpression) {
            StringExpression se = (StringExpression) e;
            return se.str;
        } else if (e instanceof FunctionCall) {

            FunctionCall fc = (FunctionCall) e;
            String id = fc.id;
            List<Expression> values = fc.value;
            Object extractedValue;

            switch (id) {
                case "tva":
                    extractedValue = getEvalResult(values.get(0));
                    return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.tvaJuridic), 2);
                case "medicalInsurance":
                    extractedValue = getEvalResult(values.get(0));
                    if (AntlrToExpression.getUserMode() == UserMode.JURIDIC)
                        return -1;
                    else if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.medicalInsurancePhysic), 2);
                    break;

                case "amenajareaTeritoriului":
                    if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                        return -1;
                    Object price = getEvalResult(values.get(0));
                    return round(Double.parseDouble(price + "") * Double.parseDouble(Util.amenajareaTeritoriuluiJuridic), 2);
                case "impozitImobiliar":
                    extractedValue = getEvalResult(values.get(0));
                    if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitImobiliarPhysic), 2);
                    else if (AntlrToExpression.getUserMode() == UserMode.JURIDIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitImobiliarJuridic), 2);
                case "impozitFunciar":
                    extractedValue = getEvalResult(values.get(0));
                    Object area = getEvalResult(values.get(1));
                    if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitFunciarPhysic) * Double.parseDouble(area + ""), 2);
                    else if (AntlrToExpression.getUserMode() == UserMode.JURIDIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitFunciarJuridic) * Double.parseDouble(area + ""), 2);
                    break;
                case "print":
                    extractedValue = getEvalResult(values.get(0));
                    if (extractedValue instanceof String) {
                        return (extractedValue + "");
                    } else if (values.get(0) instanceof Variable) {
                        return (values.get(0) + " = " + extractedValue);
                    } else if (extractedValue instanceof Double || extractedValue instanceof Integer) {
                        return (extractedValue + "");
                    }
                    break;
                case "impozitulPeVenit":
                    extractedValue = getEvalResult(values.get(0));
                    if (AntlrToExpression.getUserMode() == UserMode.PHYSIC)
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitulPeVenitPhysic), 2);
                    else if (AntlrToExpression.getUserMode() == UserMode.JURIDIC) {
//                        System.out.println(Util.impozitulPeVenitJuridic);
                        return round(Double.parseDouble(extractedValue + "") * Double.parseDouble(Util.impozitulPeVenitJuridic), 2);
                    }
                    break;
                default:
                    return ("Function " + id + " not found");
            }
            return getEvalResult(values.get(0));
        } else if (e instanceof IfExpression) {

            IfExpression ie = (IfExpression) e;
            Expression condition = ie.getCondition();
            Expression thenBranch = ie.getThenBranch();
            Expression elseBranch = ie.getElseBranch();

            Object conditionResult = getEvalResult(condition);

            if (conditionResult instanceof Boolean && (Boolean) conditionResult) {

                return getEvalResult(thenBranch);
            } else {
                if (elseBranch != null) {
                    return getEvalResult(elseBranch);
                }
            }

        } else if (e instanceof WhileExpression) {

        } else if (e instanceof Assignment) {

            Assignment a = (Assignment) e;
            String id = a.getId();
            Expression expressionValue = a.getExpressionValue();
            Object value = getEvalResult(expressionValue);

            values.put(id, value);
            return value;
        }

        return null;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
