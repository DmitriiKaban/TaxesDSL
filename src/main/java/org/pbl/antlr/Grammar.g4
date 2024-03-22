grammar Grammar;

// will import antlr in generated files
@header {
  package org.pbl.antlr;
}

// Start Variable
prog: (decl | expr)+ EOF        # Program
    ;

decl: ID ':' (INT_TYPE | DOUBLE_TYPE) '=' expr   # Declaration
    ;

// * sooner than +, so that * can be evaluated first
expr:
    methodCall                   # MethodExprCall
    | ifExpr                     # IfExprStatement
    | expr EQULITYOP expr        # EqualityComparison
    | expr RELATIONALOP expr     # RelationalComparison
    | expr '*' expr              # Multiplication
    | expr '/' expr              # Division
    | expr '+' expr              # Addition
    | expr '-' expr              # Subtraction
    | BOOL                       # Boolean
    | STRING                     # String
    | ID                         # Variable
    | NUM                        # Number
    ;

methodCall: (PRINT | TVA) LPAREN expr RPAREN
    ;

ifExpr:
    IF expr THEN expr (ELSE expr)? # IfExpression
    ;

// TOKENS
INT_TYPE : 'INTEGER';
DOUBLE_TYPE : 'DOUBLE';
BOOL : 'TRUE' | 'FALSE';
RELATIONALOP : (GT | LT | GTE | LTE);
EQULITYOP : (EQ | NEQ);

STRING : '"' (~["])* '"';

COMMA    : ',' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
SEMI     : ';' ;
EQ       : '==' ;
NEQ      : '!=' ;
GT       : '>' ;
LT       : '<' ;
GTE      : '>=' ;
LTE      : '<=' ;

IF   : 'if';
ELSE : 'else';
THEN : 'then';

PRINT    : 'print';
TVA      : 'tva';
FUNC     : 'function' ;

ID : [a-z][a-zA-Z0-9_]*;
NUM : [0-9]+ ('.' [0-9]+)? ;

COMMENT : '//' ~[\r\n]* -> skip; // ~ - negation, skip everything except \r or \n
WS : [ \r\t\n]+ -> skip; // skip whitespaces
