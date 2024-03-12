package org.pbl.expression;

public class EqualityExpression extends Expression {

    public Expression leftExpr;
    public Expression rightExpr;
    public Operator operator;

    public EqualityExpression(Expression leftExpr, Expression rightExpr, Operator operator) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "EqualityExpression{" +
                "leftExpr=" + leftExpr +
                ", rightExpr=" + rightExpr +
                ", operator=" + operator +
                '}';
    }
}
