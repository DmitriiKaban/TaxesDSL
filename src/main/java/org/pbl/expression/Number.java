package org.pbl.expression;

public class Number extends Expression {

    public int num;

    public Number(int value) {
        this.num = value;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}
