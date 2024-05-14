// Generated from Grammar.g4 by ANTLR 4.13.1

  package org.pbl.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UserModeInstantiation}
	 * labeled alternative in {@link GrammarParser#userMode}.
	 * @param ctx the parse tree
	 */
	void enterUserModeInstantiation(GrammarParser.UserModeInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UserModeInstantiation}
	 * labeled alternative in {@link GrammarParser#userMode}.
	 * @param ctx the parse tree
	 */
	void exitUserModeInstantiation(GrammarParser.UserModeInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpr}
	 * labeled alternative in {@link GrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpr(GrammarParser.AssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpr}
	 * labeled alternative in {@link GrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpr(GrammarParser.AssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(GrammarParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(GrammarParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(GrammarParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(GrammarParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(GrammarParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(GrammarParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(GrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(GrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExprStatement(GrammarParser.IfExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExprStatement(GrammarParser.IfExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodExprCall}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethodExprCall(GrammarParser.MethodExprCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodExprCall}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethodExprCall(GrammarParser.MethodExprCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(GrammarParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(GrammarParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExprStatement(GrammarParser.WhileExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExprStatement(GrammarParser.WhileExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(GrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(GrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterForExprStatement(GrammarParser.ForExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitForExprStatement(GrammarParser.ForExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(GrammarParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(GrammarParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(GrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(GrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalComparison(GrammarParser.RelationalComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalComparison(GrammarParser.RelationalComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityComparison(GrammarParser.EqualityComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityComparison(GrammarParser.EqualityComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExpression}
	 * labeled alternative in {@link GrammarParser#whileExpr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpression(GrammarParser.WhileExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExpression}
	 * labeled alternative in {@link GrammarParser#whileExpr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpression(GrammarParser.WhileExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForExpression}
	 * labeled alternative in {@link GrammarParser#forExpr}.
	 * @param ctx the parse tree
	 */
	void enterForExpression(GrammarParser.ForExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForExpression}
	 * labeled alternative in {@link GrammarParser#forExpr}.
	 * @param ctx the parse tree
	 */
	void exitForExpression(GrammarParser.ForExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpression}
	 * labeled alternative in {@link GrammarParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(GrammarParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpression}
	 * labeled alternative in {@link GrammarParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(GrammarParser.IfExpressionContext ctx);
}