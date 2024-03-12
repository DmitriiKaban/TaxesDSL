package org.pbl.expression;

import org.pbl.antlr.GrammarParser;

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

            System.out.println(e.getClass());

            if (e instanceof VariableDeclaration) {

                VariableDeclaration vd = (VariableDeclaration) e;

                double value = getEvalResult(vd.value).asDouble();
                values.put(vd.id, value);
            } else if (e instanceof FunctionCall) {

                FunctionCall fc = (FunctionCall) e;
                String id = fc.id;
                Expression value = fc.value;
                double extractedValue = getEvalResult(value).asDouble();

                switch (id) {
                    case "tva":
                        evaluations.add("Value " + extractedValue + " has TVA: " + (extractedValue * 0.2));
//                        System.out.println("Value " + extractedValue + " has TVA: " + (extractedValue * 0.2));
                        break;
                    case "print":
                        evaluations.add(String.valueOf(extractedValue));
                        break;
                    case "impozitulPeVenit":
                        evaluations.add("Impozitul pe venit: " + (extractedValue * 0.12) + ", remaining sum: " + (extractedValue * 0.88));
                        break;
                    default:
                        evaluations.add("Function " + id + " not found");
                }
            } else if (e instanceof IfStatement) {


                System.out.println("RelationalExpression: " + e);

                switch (((IfStatement) e).condition.relationalExpression.operator) {
                    case LESS_THAN:
                        if (getEvalResult(((RelationalExpression) e).leftExpr).asDouble() < getEvalResult(((RelationalExpression) e).rightExpr).asDouble()) {

//                            Expression expression = ((RelationalExpression) e).;
                        }
                        break;
                    case LESS_THAN_OR_EQUAL:
//                        return new Value(getEvalResult(((RelationalExpression) e).leftExpr).asDouble() <= getEvalResult(((RelationalExpression) e).rightExpr).asDouble());
                    case GREATER_THAN:
//                        return new Value(getEvalResult(((RelationalExpression) e).leftExpr).asDouble() > getEvalResult(((RelationalExpression) e).rightExpr).asDouble());

                        if (getEvalResult(((RelationalExpression) e).leftExpr).asDouble() > getEvalResult(((RelationalExpression) e).rightExpr).asDouble()) {
                                evaluations.add("<");
//                            System.out.println("HI");
                        }
                    case GREATER_THAN_OR_EQUAL:
//                        return new Value(getEvalResult(((RelationalExpression) e).leftExpr).asDouble() >= getEvalResult(((RelationalExpression) e).rightExpr).asDouble());
                    default:
                        throw new RuntimeException("unknown operator: " + ((RelationalExpression) e).operator);
                }

            } else { // Number or Variable or Addition or Multiplication
//                String input = e.toString();
                String input = (e != null) ? e.toString() : "null";

                double result = getEvalResult(e).asDouble();
                evaluations.add(input + " is " + result);
            }
        }

        return evaluations;
    }

    private Value getEvalResult(Expression e) {

        if (e instanceof Number) {
            Number n = (Number) e;
            return new Value(n.num);
        } else if (e instanceof Variable) {
            Variable v = (Variable) e;
            return new Value(values.get(v.id)); // variable value from symbol table
        } else if (e instanceof Addition) {
            Addition a = (Addition) e;
            return new Value(getEvalResult(a.left).asDouble() + getEvalResult(a.right).asDouble());
        } else if (e instanceof Multiplication) {
            Multiplication m = (Multiplication) e;
            return new Value(getEvalResult(m.left).asDouble() * getEvalResult(m.right).asDouble());
        } else if (e instanceof FunctionCall) {
            FunctionCall fc = (FunctionCall) e;
            String id = fc.id;
            Expression value = fc.value;
            double extractedValue = getEvalResult(value).asDouble();

            switch (id) {
                case "tva":
                    return new Value(extractedValue * 0.2);
                case "print":
                    System.out.println(extractedValue);
                    break;
                case "impozitulPeVenit":
                    return new Value(extractedValue * 0.12);
                default:
                    throw new RuntimeException("Function " + id + " not found");
            }
        } else if (e instanceof EqualityExpression) {

            return new Value(!(getEvalResult(((EqualityExpression) e).leftExpr).asDouble() - getEvalResult(((EqualityExpression) e).rightExpr).asDouble() > 0.0000001));
        } else if (e instanceof RelationalExpression) {
        }

        return new Value(-777.0); // dummy value
    }
}
