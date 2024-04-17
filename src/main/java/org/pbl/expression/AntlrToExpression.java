package org.pbl.expression;


import org.antlr.v4.runtime.Token;
import org.pbl.antlr.GrammarBaseVisitor;
import org.pbl.antlr.GrammarParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToExpression extends GrammarBaseVisitor<Expression> {

    private List<String> vars; // List of variables declared in the program
    private List<String> semanticErrors; // 1. duplicate declaration 2. undeclared variable
    public static UserMode userMode = UserMode.PHYSIC;

    public AntlrToExpression(List<String> semanticErrors) {
        this.vars = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitUserModeInstantiation(GrammarParser.UserModeInstantiationContext ctx) {

        userMode = UserMode.valueOf(ctx.ID().getText().toUpperCase());

        return null;
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
    public Expression visitSubtraction(GrammarParser.SubtractionContext ctx) {

        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));

        return new Subtraction(left, right);
    }

    @Override
    public Expression visitDivision(GrammarParser.DivisionContext ctx) {

        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));

        return new Division(left, right);
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

        String id = "";
        if (ctx.PRINT() != null) {
            id = ctx.PRINT().getText();
        }
        else if (ctx.TVA() != null) {
            id = ctx.TVA().getText();
        }
        Expression expression = visit(ctx.getChild(2));

        return new FunctionCall(id, expression);
    }

    @Override
    public Expression visitMethodExprCall(GrammarParser.MethodExprCallContext ctx) {

        return visitMethodCall(ctx.methodCall());
    }

    @Override
    public Expression visitIfExpression(GrammarParser.IfExpressionContext ctx) {
        Expression condition = visit(ctx.expr(0)); // The condition expression
        Expression thenBranch = visit(ctx.expr(1)); // The 'then' branch expression

        Expression elseBranch = null;
        if (ctx.expr(2) != null) { // Check if there's an 'else' branch
            elseBranch = visit(ctx.expr(2));
        }

        return new IfExpression(condition, thenBranch, elseBranch);
    }

    @Override
    public Expression visitIfExprStatement(GrammarParser.IfExprStatementContext ctx) {

        return new IfExpression(visit(ctx.ifExpr().getChild(1)), visit(ctx.ifExpr().getChild(3)), visit(ctx.ifExpr().getChild(5)));
    }

    @Override
    public Expression visitBoolean(GrammarParser.BooleanContext ctx) {
        String boolText = ctx.getText(); 
        boolean boolValue = java.lang.Boolean.parseBoolean(boolText);
        return new BooleanExpression(boolValue);
    }

    @Override
    public Expression visitString(GrammarParser.StringContext ctx) {
        String str = ctx.getText().substring(1, ctx.getText().length() - 1); // to remove " from the beginning and end of the string
        return new StringExpression(str);
    }

    @Override
    public Expression visitRelationalComparison(GrammarParser.RelationalComparisonContext ctx) {
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));

        switch (ctx.RELATIONALOP().toString()) {
            case "<":
                return new RelationalComparison(left, Relational.LESS_THAN, right);
            case ">":
                return new RelationalComparison(left, Relational.GREATER_THAN, right);
            case "<=":
                return new RelationalComparison(left, Relational.LESS_THAN_OR_EQUAL, right);
            case ">=":
                return new RelationalComparison(left, Relational.GREATER_THAN_OR_EQUAL, right);
            default:
                return null;
        }
    }

    @Override
    public Expression visitEqualityComparison(GrammarParser.EqualityComparisonContext ctx) {
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));

        switch (ctx.EQULITYOP().toString()) {
            case "==":
                return new EqualityComparison(left, Equality.EQUALS, right);
            case "!=":
                return new EqualityComparison(left, Equality.NOT_EQUALS, right);
            default:
                return null;
        }
    }

    public static UserMode getUserMode() {
        return userMode;
    }

}
