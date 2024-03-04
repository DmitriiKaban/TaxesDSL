package org.pbl.expression;

import org.pbl.antlr.GrammarBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends GrammarBaseVisitor<Program> {

    public List<String> semanticErrors; // 1. duplicate declaration 2. undeclared variable

    @Override
    public Program visitProgram(org.pbl.antlr.GrammarParser.ProgramContext ctx) {

        Program program = new Program();

        semanticErrors = new ArrayList<>();

        // helper visitor for transforming subtrees into expressions
        AntlrToExpression expressionVisitor = new AntlrToExpression(semanticErrors);

        for (int i = 0; i < ctx.getChildCount(); i++) {

            if (i == ctx.getChildCount() - 1) {
                // last child is EOF, don't visit it
                break;
            } else
                program.addExpression(expressionVisitor.visit(ctx.getChild(i)));
        }

        return program;
    }
}
