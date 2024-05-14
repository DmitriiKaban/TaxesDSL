package org.pbl.expression;

import java.util.List;

public class FunctionCall extends Expression {

    public String id;
    public List<Expression> value;

    public FunctionCall(String id, List<Expression> expression) {
        this.id = id;
        this.value = expression;
    }

    @Override
    public String toString() {

        return "FunctionCall: " + id + ", with value: " + value.toString();
    }
}
