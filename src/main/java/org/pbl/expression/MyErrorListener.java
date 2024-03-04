package org.pbl.expression;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

public class MyErrorListener extends BaseErrorListener {

    public static boolean hasError = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        hasError = true;

        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        System.out.println("Syntax Error!");
        System.out.println("Token " + "\"" + ((Token) offendingSymbol).getText() + "\""
                + " (line " + line + " , position " + charPositionInLine + ")"
                + " caused syntax error: " + msg);
        System.out.println("Rule Stack: " + stack);
    }
}
