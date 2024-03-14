package org.pbl.expression;

public class BooleanExpression extends Expression {

    public java.lang.Boolean bool;

    public BooleanExpression(java.lang.Boolean value) {
        this.bool = value;
    }

    @Override
    public String toString() {
        return bool.toString();
    }
}
