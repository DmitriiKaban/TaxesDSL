package org.pbl.expression;

public class Number extends Expression {

    public Double num;

    public Number(double value) {
        this.num = value;
    }

    @Override
    public String toString() {
        return Double.toString(num);
    }
}
