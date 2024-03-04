grammar Grammar;

// will import antlr in generated files
@header {
  package org.pbl.antlr;
}

// TOKENS
ID : [a-z][a-zA-Z0-9_]*;
NUM : [0-9]+ ('.' [0-9]+)? ;
COMMENT : '//' ~[\r\n]* -> skip; // ~ - negation, skip everything except \r or \n
WS : [ \r\t\n]+ -> skip; // skip whitespaces

INT_TYPE : 'INTEGER';
COMMA    : ',' ;
LPAREN   : '(' ;
RPAREN   : ')' ;

// Star Variable
prog: (decl | expr | methodCall)+ EOF        # Program
    ;

decl: ID ':' INT_TYPE '=' NUM   # Declaration
    ;

methodCall: ID LPAREN expr RPAREN # FunctionCall
    ;

// * sooner than +, so that * can be evaluated first
expr:
    expr '*' expr                # Multiplication
    | expr '+' expr              # Addition
    | ID                         # Variable
    | NUM                        # Number
    ;
