grammar zaohua;

// 词法分析器规则
IF: 'if';
ELSE: 'else';
ELIF: 'elif';
FOR: 'for';
FUNC: 'func';
RETURN: 'return';
IN: 'in';
TRUE: 'true';
FALSE: 'false';

// 操作符
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';
EQ: '==';
NEQ: '!=';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
ASSIGN: '=';
DECLARE_ASSIGN: ':='; // 海象符号
COLON: ':';
SEMI: ';';
COMMA: ',';

// 括号
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';

// 数据类型
BOOLEAN: TRUE | FALSE;
ID: [a-zA-Z_][a-zA-Z0-9_]*;  // 标识符
NUMBER: [0-9]+ ('.' [0-9]+)?; // 数字，包括整数和浮点数

NEWLINE : ( '\r\n' | '\r' | '\n' )+ ; // 支持跨平台换行符

// 词法分析器规则
STRING
    : '"' (~["\\] | '\\' .)* '"'    // 支持双引号包围的字符串
    | '\'' (~['\\] | '\\' .)* '\''  // 支持单引号包围的字符串
    | 'r'? '"' ( . | NEWLINE )*? '"'       // 支持多行原始字符串（双引号）
    | 'r'? '\'' ( . | NEWLINE )*? '\''      // 支持多行原始字符串（单引号）
    | 'f' '"' (~["\\] | '\\' .)* '"'     // 支持格式字符串（双引号）
    | 'f' '\'' (~['\\] | '\\' .)* '\''    // 支持格式字符串（单引号）
    ;



// 注释和空白字符
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

// 语法分析器规则
program
    : statement* EOF  // 程序由多个语句组成，直到文件结束
    ;

// 各种语句类型
statement
    : ifStatement
    | forStatement
    | funcDeclaration
    | aliasDeclaration  // 修改后的别名声明
    | returnStatement
    | assignment
    | declaration  // 海象符号声明
    | expressionStatement
    ;



// if 语句
ifStatement
    : IF expression COLON block (elifStatement | elseStatement)?  // 支持 elif 和 else
    ;
elifStatement
    : ELIF expression COLON block  // 可选的 elif 分支
    ;
elseStatement
    : ELSE COLON block  // 可选的 else 分支
    ;

// for 循环语句
forStatement
    : FOR ID IN expression COLON block  // 简化的 for-in 循环语法
    ;

// 函数声明，支持函数签名
funcDeclaration
    : FUNC ID LPAREN paramList? RPAREN (COLON typeSpecifier)? COLON block  // 函数定义，带参数列表和可选的返回类型
    ;

// 函数别名声明，使用冒号定义别名
aliasDeclaration
    : ID COLON ID SEMI  // 使用冒号定义别名，格式为 newName : originalName;
    ;

// return 语句
returnStatement
    : RETURN expression? SEMI  // return 语句，支持带或不带返回值
    ;

// 赋值语句
assignment
    : ID ASSIGN expression SEMI  // 简单的变量赋值
    ;

// 声明语句（支持类型推断）
declaration
    : ID DECLARE_ASSIGN expression SEMI  // 使用 := 进行声明和类型推断
    ;

// 表达式语句
expressionStatement
    : expression SEMI  // 表达式后跟分号
    ;

// 代码块
block
    : LBRACE statement* RBRACE  // 用大括号包裹的语句块
    ;

// 参数列表
paramList
    : param (COMMA param)*  // 支持多个参数，中间用逗号分隔
    ;
param
    : ID COLON typeSpecifier  // 参数由名称和类型组成
    ;

// 类型说明符
typeSpecifier
    : 'int'
    | 'float'
    | 'bool'
    | 'string'
    | ID  // 用户自定义类型
    ;

// 表达式
expression
    : equalityExpression
    | funcCall  // 新增对函数调用的支持
    ;

// 函数调用表达式，支持别名调用
funcCall
    : ID LPAREN argumentList? RPAREN  // 函数调用，使用 ID 作为函数名或别名
    ;

// 参数列表
argumentList
    : expression (COMMA expression)*  // 参数可以是多个表达式
    ;

// 等式表达式
equalityExpression
    : relationalExpression (EQ relationalExpression | NEQ relationalExpression)*  // 支持 == 和 != 操作
    ;

// 比较表达式
relationalExpression
    : additiveExpression (GT additiveExpression | LT additiveExpression | GTE additiveExpression | LTE additiveExpression)*  // 支持 > < >= <= 比较运算符
    ;

// 加法表达式
additiveExpression
    : multiplicativeExpression (PLUS multiplicativeExpression | MINUS multiplicativeExpression)*  // 支持加法和减法运算
    ;

// 乘法表达式
multiplicativeExpression
    : primary (MUL primary | DIV primary | MOD primary)*  // 支持乘法、除法和取模运算
    ;

// 原子表达式
primary
    : ID
    | NUMBER
    | STRING
    | BOOLEAN
    | LPAREN expression RPAREN  // 支持括号中的表达式
    ;
