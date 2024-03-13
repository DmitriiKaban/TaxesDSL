package org.pbl.expression;

public class RelationalComparison extends Expression {

    public Expression left;
    public Relational relational;
    public Expression right;

    public RelationalComparison(Expression left, Relational relational, Expression right) {
        this.left = left;
        this.relational = relational;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " " + relational + " "  + right.toString();
    }
}
