package org.pbl.expression;

public class StringExpression extends Expression {

    public String str;

    public StringExpression(String value) {
        this.str = value;
    }

    @Override
    public String toString() {
        return str;
    }
}
