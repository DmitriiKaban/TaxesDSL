package org.pbl.expression;


import org.antlr.v4.runtime.Token;
import org.pbl.antlr.GrammarBaseVisitor;
import org.pbl.antlr.GrammarParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToExpression extends GrammarBaseVisitor<Expression> {

    private List<String> vars; // List of variables declared in the program
    private List<String> semanticErrors; // 1. duplicate declaration 2. undeclared variable

    public AntlrToExpression(List<String> semanticErrors) {
        this.vars = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaration(GrammarParser.DeclarationContext ctx) {

        String id = ctx.getChild(0).getText();
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine();

        if (vars.contains(id)) {
            semanticErrors.add("Error: Duplicate declaration of variable " + id + " at line: " + line + ", column: " + column);
        } else {
            vars.add(id);
        }

        String type = ctx.getChild(2).getText();

        Expression expressionValue = visit(ctx.getChild(4));

        return new VariableDeclaration(id, type, expressionValue);
    }

    @Override
    public Expression visitMultiplication(GrammarParser.MultiplicationContext ctx) {

        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));

        return new Multiplication(left, right);
    }

    @Override
    public Expression visitAddition(GrammarParser.AdditionContext ctx) {

        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));

        return new Addition(left, right);
    }

    @Override
    public Expression visitVariable(GrammarParser.VariableContext ctx) {

        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine();

        String id = ctx.getChild(0).getText();
        if (!vars.contains(id)) {
            semanticErrors.add("Error: Undeclared variable " + id + " at line: " + line + ", column: " + column);
        }

        return new Variable(id);
    }

    @Override
    public Expression visitNumber(GrammarParser.NumberContext ctx) {

        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);

        return new Number(num);
    }

    @Override
    public Expression visitMethodCall(GrammarParser.MethodCallContext ctx) {

        String id = ctx.ID().getText();
        Expression expression = visit(ctx.getChild(2));

//        System.out.println("HI methodCall");
//        System.out.println(expression.toString());

        return new FunctionCall(id, expression);
    }

    @Override
    public Expression visitMethodExprCall(GrammarParser.MethodExprCallContext ctx) {

        return visitMethodCall(ctx.methodCall());
    }
}
