package org.pbl.expression;

public class ConditionBlock extends Expression {

    public RelationalExpression relationalExpression;
    public Expression stateBlock;

    public ConditionBlock(RelationalExpression relationalExpression, Expression stateBlock) {
        this.relationalExpression = relationalExpression;
        this.stateBlock = stateBlock;
    }

    @Override
    public String toString() {
        return "ConditionBlock{" +
                "relationalExpression=" + relationalExpression +
                ", stateBlock=" + stateBlock;
    }
}
