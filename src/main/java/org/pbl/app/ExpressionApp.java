package org.pbl.app;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.pbl.antlr.GrammarLexer;
import org.pbl.antlr.GrammarParser;
import org.pbl.expression.AntlrToProgram;
import org.pbl.expression.ExpressionProcessor;
import org.pbl.expression.MyErrorListener;
import org.pbl.expression.Program;

import java.io.IOException;

public class ExpressionApp {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: file name");
        } else {

            String fileName = args[0];
            GrammarParser parser = getParser(fileName);

            ParseTree antlrAST = parser.prog();

            if (MyErrorListener.hasError) {
                return;
            }

            // create visitor to receive expression objects
            AntlrToProgram programVisitor = new AntlrToProgram();
            Program prog = programVisitor.visit(antlrAST);

            if (programVisitor.semanticErrors.isEmpty()) {

                ExpressionProcessor processor = new ExpressionProcessor(prog.expressions);
                for (String result : processor.getEvaluationResults()) {
                    System.out.println(result);
                }

            } else { // print errors

                for (String error : programVisitor.semanticErrors) {
                    System.out.println(error);
                }

            }
        }
    }

    private static GrammarParser getParser(String fileName) {

        GrammarParser parser = null;

        try {

            CharStream input = CharStreams.fromFileName(fileName);
            GrammarLexer lexer = new GrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GrammarParser(tokens);

            // syntax error handling
            parser.removeErrorListeners();
            parser.addErrorListener(new MyErrorListener());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }
}
