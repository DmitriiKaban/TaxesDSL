package org.pbl.expression;

public class Boolean extends Expression {

    public java.lang.Boolean bool;

    public Boolean(java.lang.Boolean value) {
        this.bool = value;
    }

    @Override
    public String toString() {
        return bool.toString();
    }
}
