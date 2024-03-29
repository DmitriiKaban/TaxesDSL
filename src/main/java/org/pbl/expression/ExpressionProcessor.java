package org.pbl.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.round;

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
                Expression value = fc.value;
                Object extractedValue = getEvalResult(value);

                switch (id) {
                    case "tva":
                        evaluations.add("Value " + extractedValue + " has TVA: " + (Double.parseDouble(extractedValue + "") * 0.2));
                        break;
                    case "print":
                        if (extractedValue instanceof String) {
                            evaluations.add(extractedValue + "");
                        } else if (value instanceof Variable) {
                            evaluations.add(value + " = " + extractedValue);
                        } else if (extractedValue instanceof Double || extractedValue instanceof Integer) {
                            evaluations.add(extractedValue + "");
                        }
                        break;
                    case "impozitulPeVenit":
                        evaluations.add("Impozitul pe venit: " + (Double.parseDouble(extractedValue + "") * 0.12) + ", remaining sum: " + (Double.parseDouble(extractedValue + "") * 0.88));
                        break;
                    default:
                        evaluations.add("Function " + id + " not found");
                }
            } else if (e instanceof IfExpression) {

                IfExpression ie = (IfExpression) e;
                evaluations.add(getEvalResult(ie) + "");

            } else { // Number or Variable or Addition or Multiplication or Division or Subtraction
                String input = (e != null) ? e.toString() : "null";

                Object result = getEvalResult(e);
                evaluations.add(input + " is " + result.toString());
            }
        }

        return evaluations;
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
                return (Double) left - (Double) right;
            } else {
                throw new IllegalArgumentException("Invalid operation: cannot subtract non-numeric values");
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
            Expression value = fc.value;
            String id = fc.id;
            Object extractedValue = getEvalResult(value);

            switch (id) {
                case "tva":
                    double tvaResult = Double.parseDouble(extractedValue + "") * 0.2;
                    return round(tvaResult, 2);
                case "print":
                    return extractedValue;
                case "impozitulPeVenit":
                    double impozitulResult = Double.parseDouble(extractedValue + "") * 0.12;
                    return round(impozitulResult, 2);
            }
            return getEvalResult(value);
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
