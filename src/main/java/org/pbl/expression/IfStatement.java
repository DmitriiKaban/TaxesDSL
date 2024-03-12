package org.pbl.expression;

public class IfStatement extends Expression {

    public ConditionBlock condition;

    public IfStatement(ConditionBlock condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "IfStatement{" +
                "condition=" + condition +
                '}';
    }
}
