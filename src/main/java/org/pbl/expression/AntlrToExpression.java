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
        double num = Double.parseDouble(numText);

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

    @Override
    public Expression visitIfConditionStatement(GrammarParser.IfConditionStatementContext ctx) {

        List<GrammarParser.ConditionBlockContext> conditions = ctx.conditionBlock();
        Expression expression = null;

        System.out.println(conditions.get(0).expr().getText());
        System.out.println(conditions.get(0).stateBlock().getText());

        for (GrammarParser.ConditionBlockContext condition : conditions) {

            Expression evaluated = this.visit(condition.expr());

//            System.out.println("Evaluated: " + evaluated.toString());
            if (evaluated instanceof Boolean && ((Boolean) evaluated).value) {
                expression = this.visit(condition.expr());
                break;
            }
        }

        if (expression == null && ctx.stateBlock() != null) {
            expression = this.visit(ctx.stateBlock());
        }

        return expression;
    }

//    @Override
//    public Expression visitEqualityExpr(GrammarParser.EqualityExprContext ctx) {
//
//        Expression left = visit(ctx.getChild(0));
//        Expression right = visit(ctx.getChild(2));
//
//        // TODO: Implement equality and inequality
//        switch (ctx.op.getType()) {
//            case GrammarParser.EQ:
//                if (left instanceof Variable && right instanceof Variable) {
//                    return new Boolean(((Number) left).num - ((Number) right).num < 0.00000000001);
//                }
//            case GrammarParser.NEQ:
//                if (left instanceof Number && right instanceof Number)
//                    return new Boolean(((Number) left).num - ((Number) right).num >= 0.00000000001);
//            default:
//                throw new RuntimeException("unknown operator: " + GrammarParser.tokenNames[ctx.op.getType()]);
//        }
//    }
//
//    @Override
//    public Expression visitRelationalExpr(GrammarParser.RelationalExprContext ctx) {
//
//        Expression left = visit(ctx.getChild(0));
//        Expression right = visit(ctx.getChild(2));
//
//        switch (ctx.op.getType()) {
//            case GrammarParser.SMALLER:
//                if (left instanceof Number && right instanceof Number)
//                    return new Boolean(((Number) left).num < ((Number) right).num);
//            case GrammarParser.SMALLEREQ:
//                if (left instanceof Number && right instanceof Number)
//                    return new Boolean(((Number) left).num <= ((Number) right).num);
//            case GrammarParser.GREATER:
//                if (left instanceof Number && right instanceof Number)
//                    return new Boolean(((Number) left).num > ((Number) right).num);
//            case GrammarParser.GREATEREQ:
//                if (left instanceof Number && right instanceof Number)
//                    return new Boolean(((Number) left).num >= ((Number) right).num);
//            default:
//                throw new RuntimeException("unknown operator: " + GrammarParser.tokenNames[ctx.op.getType()]);
//        }
//    }

}
