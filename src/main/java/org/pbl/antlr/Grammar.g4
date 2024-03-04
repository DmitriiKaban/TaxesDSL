grammar Grammar;

// will import antlr in generated files
@header {
  package org.pbl.antlr;
}

// Star Variable
prog: (decl | expr)+ EOF        # Program
    ;

decl: ID ':' INT_TYPE '=' NUM   # Declaration
    ;

// * sooner than +, so that * can be evaluated first
expr: expr '*' expr     # Multiplication
    | expr '+' expr     # Addition
    | ID                # Variable
    | NUM               # Number
    ;

ID : [a-z][a-zA-Z0-9_]*;
NUM : '0' | '-'?[1-9][0-9]*;
INT_TYPE : 'INTEGER';
// ~ - negation, skip everythig except \r or \n
COMMENT : '//' ~[\r\n]* -> skip;
// skip whitespaces
WS : [ \t\n]+ -> skip;