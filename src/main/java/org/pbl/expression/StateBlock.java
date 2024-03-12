package org.pbl.expression;

import java.util.List;

public class StateBlock extends Expression {

    public List<Expression> methodExpr;

    public StateBlock(List<Expression> expression) {
        methodExpr = expression;
    }

    @Override
    public String toString() {
        return "StateBlock{" +
                "expression=" + methodExpr.toString() +
                '}';
    }
}
