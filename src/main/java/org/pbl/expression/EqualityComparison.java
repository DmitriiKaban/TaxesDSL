package org.pbl.expression;

public class EqualityComparison extends Expression {

    public Expression left;
    public Equality equality;
    public Expression right;

    public EqualityComparison(Expression left, Equality equality, Expression right) {
        this.left = left;
        this.equality = equality;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " " + equality + " "  + right.toString();
    }
}
