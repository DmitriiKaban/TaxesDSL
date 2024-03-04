package org.pbl.expression;

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
            } else { // Number or Variable or Addition or Multiplication
                String input = e.toString();
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
