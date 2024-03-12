grammar Grammar;

// will import antlr in generated files
@header {
  package org.pbl.antlr;
}

// Star Variable
prog: (decl | expr | ifStatement)+ EOF        # Program
    ;

decl: ID ':' (INT_TYPE | DOUBLE_TYPE) '=' expr   # Declaration
    ;

methodCall: ID LPAREN expr RPAREN
    ;

ifStatement: IF conditionBlock (ELSE IF conditionBlock)* (ELSE stateBlock)?    # IfConditionStatement
    ;

conditionBlock: expr stateBlock;

stateBlock: OBRACE (decl | expr | ifStatement)+ CBRACE;

// * sooner than +, so that * can be evaluated first
expr:
    expr '*' expr                # Multiplication
    | expr '+' expr              # Addition
    | ID                         # Variable
    | NUM                        # Number
    | methodCall                 # MethodExprCall
    | expr op=(SMALLEREQ | GREATEREQ | SMALLER | GREATER) expr # RelationalExpr
    | expr op=(EQ | NEQ) expr       # EqualityExpr
    | (TRUE | FALSE)             # BooleanExpr
    ;


// TOKENS
INT_TYPE : 'INTEGER';
DOUBLE_TYPE : 'DOUBLE';
IF       : 'if';
ELSE       : 'else';
TRUE : 'true';
FALSE : 'false';
COMMENT : '//' ~[\r\n]* -> skip; // ~ - negation, skip everything except \r or \n
WS : [ \r\t\n]+ -> skip; // skip whitespaces
COMMA    : ',' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
OBRACE   : '{';
CBRACE   : '}';
SEMI     : ';' ;
FUNC     : 'function' ;
GREATEREQ: '>=';
SMALLEREQ: '<=';
GREATER  : '>';
SMALLER  : '<';
EQ       : '==';
NEQ       : '!=';
OR       : '||';
AND      : '&&';
ID : [a-z][a-zA-Z0-9_]*;
NUM : [0-9]+ ('.' [0-9]+)? ;

STRING: '"' (~["\r\n] | '""')* '"'
    ;
