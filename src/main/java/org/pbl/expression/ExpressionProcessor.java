package org.pbl.expression;

import org.pbl.antlr.GrammarParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {

    List<Expression> list;

    public Map<String, Integer> values; // symbol table for variables and their values

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {

        List<String> evaluations = new ArrayList<>();

        for (Expression e : list) {

            if (e instanceof VariableDeclaration) {
                VariableDeclaration vd = (VariableDeclaration) e;
                values.put(vd.id, vd.value);
            } else if (e instanceof FunctionCall) {

                FunctionCall fc = (FunctionCall) e;
                String id = fc.id;
                Expression value = fc.value;
                int extractedValue = getEvalResult(value);

                switch (id) {
                    case "tva":
                        System.out.println("Value " + extractedValue + " has TVA: " + (extractedValue * 0.2));
                        break;
                    default:
                        System.out.println("Function " + id + " not found");
                }
            } else { // Number or Variable or Addition or Multiplication
//                String input = e.toString();
                String input = (e != null) ? e.toString() : "null";

                int result = getEvalResult(e);
                evaluations.add(input + " is " + result);
            }
        }

        return evaluations;
    }

    private int getEvalResult(Expression e) {

        int result = 0;

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
        }

        return result;
    }
}
