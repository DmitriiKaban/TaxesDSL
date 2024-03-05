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
            } else { // Number or Variable or Addition or Multiplication
//                String input = e.toString();
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
                    System.out.println(extractedValue);
                    break;
                case "impozitulPeVenit":
                    result = extractedValue * 0.12;
                    break;
                default:
                    System.out.println("Function " + id + " not found");
            }
        }

        return result;
    }
}
