grammar Hello;

// will import antlr in generated files
@header {
  package org.pbl.antlr;
}

// Star Variable
prog: (decl | expr)+ EOF
    ;

decl: ID ':' INT_TYPE '=' NUM
    ;

// * sooner than +, so that * can be evaluated first
expr: expr '*' expr
    | expr '+' expr
    | ID
    | NUM
    ;

ID : [a-z][a-zA-Z0-9_]*;
NUM : '0' | '-'?[1-9][0-9]*;
INT_TYPE : 'INTEGER';
// ~ - negation, skip everythig except \r or \n
COMMENT : '//' ~[\r\n]* -> skip;
// skip whitespaces
WS : [ \t\n]+ -> skip;