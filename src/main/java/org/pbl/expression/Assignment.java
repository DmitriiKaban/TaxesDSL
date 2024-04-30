package org.pbl.expression;

public class Assignment extends Expression {

    private String id;
    private Expression expressionValue;

    public Assignment(String id, Expression expressionValue) {
        this.id = id;
        this.expressionValue = expressionValue;
    }

    public String getId() {
        return id;
    }

    public Expression getExpressionValue() {
        return expressionValue;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id='" + id + '\'' +
                ", expressionValue=" + expressionValue +
                '}';
    }
}
