package org.pbl.expression;

import java.util.List;

public class WhileExpression extends Expression {

    private Expression condition;
    private List<Expression> bodyExpressions;

    public WhileExpression(Expression condition, List<Expression> bodyExpressions) {
        this.condition = condition;
        this.bodyExpressions = bodyExpressions;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Expression> getBodyExpressions() {
        return bodyExpressions;
    }

    @Override
    public String toString() {
        return "WhileExpression{" +
                "condition=" + condition +
                ", bodyExpressions=" + bodyExpressions +
                '}';
    }
}
