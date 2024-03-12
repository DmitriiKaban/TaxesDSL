package org.pbl.expression;

public class RelationalExpression extends Expression {

    public Expression leftExpr;
    public Expression rightExpr;
    public Operator operator;

    public RelationalExpression(Expression leftExpr, Expression rightExpr, Operator operator) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "RelationalExpression{" +
                "leftExpr=" + leftExpr +
                ", rightExpr=" + rightExpr +
                ", operator=" + operator +
                '}';
    }
}
