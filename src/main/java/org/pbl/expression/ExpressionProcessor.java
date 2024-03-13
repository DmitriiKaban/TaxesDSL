package org.pbl.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {

    List<Expression> list;

    public Map<String, Double> values; // symbol table for variables and their values

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {

        List<String> evaluations = new ArrayList<>();

        for (Expression e : list) {

            if (e instanceof VariableDeclaration) {

                VariableDeclaration vd = (VariableDeclaration) e;

                double value = getEvalResult(vd.value);
                values.put(vd.id, value);
            } else if (e instanceof FunctionCall) {

                FunctionCall fc = (FunctionCall) e;
                String id = fc.id;
                Expression value = fc.value;
                double extractedValue = getEvalResult(value);

                switch (id) {
                    case "tva":
                        evaluations.add("Value " + extractedValue + " has TVA: " + (extractedValue * 0.2));
                        break;
                    case "print":
                        evaluations.add(value.toString() + " = " + extractedValue);
                        break;
                    case "impozitulPeVenit":
                        evaluations.add("Impozitul pe venit: " + (extractedValue * 0.12) + ", remaining sum: " + (extractedValue * 0.88));
                        break;
                    default:
                        evaluations.add("Function " + id + " not found");
                }
            } else if (e instanceof IfExpression) {

                IfExpression ie = (IfExpression) e;
                evaluations.add(getEvalResult(ie) + "");

            } else { // Number or Variable or Addition or Multiplication or Division or Subtraction
                String input = (e != null) ? e.toString() : "null";

                double result = getEvalResult(e);
                evaluations.add(input + " is " + result);
            }
        }

        return evaluations;
    }

    private double getEvalResult(Expression e) {

        double result = 0;


        if (e instanceof Number) {
            Number n = (Number) e;
            result = n.num;
        } else if (e instanceof Variable) {
            Variable v = (Variable) e;
            result = values.get(v.id); // variable value from symbol table
        } else if (e instanceof Addition) {
            Addition a = (Addition) e;
            result = getEvalResult(a.left) + getEvalResult(a.right);
        } else if (e instanceof Multiplication) {
            Multiplication m = (Multiplication) e;
            result = getEvalResult(m.left) * getEvalResult(m.right);
        } else if (e instanceof Division) {
            Division d = (Division) e;
            result = getEvalResult(d.left) / getEvalResult(d.right);
        } else if (e instanceof Subtraction) {
            Subtraction s = (Subtraction) e;
            result = getEvalResult(s.left) - getEvalResult(s.right);
        } else if (e instanceof FunctionCall) {
            FunctionCall fc = (FunctionCall) e;
            String id = fc.id;
            Expression value = fc.value;
            double extractedValue = getEvalResult(value);

            switch (id) {
                case "tva":
                    result = extractedValue * 0.2;
                    break;
                case "print":
                    result = extractedValue;
                    break;
                case "impozitulPeVenit":
                    result = extractedValue * 0.12;
                    break;
                default:
                    System.out.println("Function " + id + " not found");
            }
        } else if (e instanceof Boolean) {
            Boolean b = (Boolean) e;
            result = b.bool ? 1 : 0;

        } else if (e instanceof IfExpression) {

            IfExpression ie = (IfExpression) e;
            Expression condition = ie.getCondition();
            Expression thenBranch = ie.getThenBranch();
            Expression elseBranch = ie.getElseBranch();

            double conditionResult = getEvalResult(condition);

            if (conditionResult == 1) {
                result = getEvalResult(thenBranch);
            } else {
                if (elseBranch != null) {
                    result = getEvalResult(elseBranch);
                }
            }
        } else if (e instanceof EqualityComparison) {

            EqualityComparison ec = (EqualityComparison) e;
            Expression left = ec.left;
            Expression right = ec.right;
            Equality equality = ec.equality;

            double leftResult = getEvalResult(left);
            double rightResult = getEvalResult(right);

            switch (equality) {
                case EQUALS:
                    result = leftResult == rightResult ? 1 : 0;
                    break;
                case NOT_EQUALS:
                    result = leftResult != rightResult ? 1 : 0;
                    break;
            }
        } else if (e instanceof RelationalComparison) {

            RelationalComparison rc = (RelationalComparison) e;
            Expression left = rc.left;
            Expression right = rc.right;
            Relational relational = rc.relational;

            double leftResult = getEvalResult(left);
            double rightResult = getEvalResult(right);

            switch (relational) {
                case LESS_THAN:
                    result = leftResult < rightResult ? 1 : 0;
                    break;
                case GREATER_THAN:
                    result = leftResult > rightResult ? 1 : 0;
                    break;
                case LESS_THAN_OR_EQUAL:
                    result = leftResult <= rightResult ? 1 : 0;
                    break;
                case GREATER_THAN_OR_EQUAL:
                    result = leftResult >= rightResult ? 1 : 0;
                    break;
            }
        }

        return result;
    }
}
