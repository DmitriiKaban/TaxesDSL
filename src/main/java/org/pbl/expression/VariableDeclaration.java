package org.pbl.expression;

public class VariableDeclaration extends Expression {

    public String id;
    public String type;
    public Expression value;

    public VariableDeclaration(String id, String type, Expression value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
}
