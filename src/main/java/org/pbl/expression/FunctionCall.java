package org.pbl.expression;

public class FunctionCall extends Expression {

    public String id;
    public Expression value;

    public FunctionCall(String id, Expression expression) {
        this.id = id;
        this.value = expression;
    }

    @Override
    public String toString() {

        return "FunctionCall: " + id + ", with value: " + value.toString();
    }
}
