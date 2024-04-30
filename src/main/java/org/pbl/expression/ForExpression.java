package org.pbl.expression;

import java.util.List;

public class ForExpression extends Expression {

    private String id;
    private Expression baseValue;
    private Expression endValue;
    private Expression step;
    private List<Expression> bodyExpressions;
    private boolean hasAssignment;
    private boolean hasStep;

    public ForExpression(String id, Expression baseValue, Expression end, Expression step, List<Expression> body, boolean hasAssignment, boolean hasStep) {
        this.id = id;
        this.baseValue = baseValue;
        this.endValue = end;
        this.step = step;
        this.bodyExpressions = body;
        this.hasAssignment = hasAssignment;
        this.hasStep = hasStep;
    }

    public String getId() {
        return id;
    }

    public Expression getBaseValue() {
        return baseValue;
    }

    public Expression getEndValue() {
        return endValue;
    }

    public Expression getStep() {
        return step;
    }

    public List<Expression> getBodyExpressions() {
        return bodyExpressions;
    }

    public boolean hasAssignment() {
        return hasAssignment;
    }

    public boolean hasStep() {
        return hasStep;
    }

    @Override
    public String toString() {
        return "ForExpression{" +
                "id='" + id + '\'' +
                ", baseValue=" + baseValue +
                ", endValue=" + endValue +
                ", step=" + step +
                ", bodyExpressions=" + bodyExpressions +
                '}';
    }
}
