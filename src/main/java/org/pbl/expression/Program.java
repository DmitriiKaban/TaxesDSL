package org.pbl.expression;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public List<Expression> expressions;

    public Program() {
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }
}
