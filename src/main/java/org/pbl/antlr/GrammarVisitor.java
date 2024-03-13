// Generated from Grammar.g4 by ANTLR 4.13.1

  package org.pbl.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GrammarParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(GrammarParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpression}
	 * labeled alternative in {@link GrammarParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(GrammarParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodExprCall}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExprCall(GrammarParser.MethodExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(GrammarParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(GrammarParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(GrammarParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(GrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(GrammarParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExprStatement}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExprStatement(GrammarParser.IfExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(GrammarParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalComparison(GrammarParser.RelationalComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityComparison(GrammarParser.EqualityComparisonContext ctx);
}