grammar MyLang;

// Entry point of the grammar
prog:   statement+ ;

// Language.g4


// 词法规则
// 字符串常量
STRING_LITERAL : '"' ('\\"' | ~['\\'])* '"' ;

// 原始字符串
RAW_STRING_LITERAL : 'r"' ('\\"' | ~["\\"])* '"' ;

// 格式化字符串
FORMAT_STRING_LITERAL : 'f"' ('\\{[^}]*\\}' | ~['"'])* '"' ;

// 数字常量
NUMBER : ('-'? [0-9]+ ('.' [0-9]+)?) ;

// 布尔常量
BOOLEAN : 'true' | 'false' ;

// 运算符
PLUS : '+' ;
MINUS : '-' ;
MULTIPLY : '*' ;
DIVIDE : '/' ;
INTEGER_DIVIDE : '//' ;
MODULO : '%' ;
POWER : '**' ;

LOGICAL_AND : '&&' ;
LOGICAL_OR : '||' ;
LOGICAL_NOT : '!' ;
LOGICAL_XOR : '^' ;

BIT_AND : '&' ;
BIT_OR : '|' ;
BIT_XOR : '^' ;
BIT_NOT : '~' ;
LEFT_SHIFT : '<<' ;
RIGHT_SHIFT : '>>' ;

EQUAL : '==' ;
NOT_EQUAL : '!=' ;
GREATER_THAN : '>' ;
LESS_THAN : '<' ;
GREATER_EQUAL : '>=' ;
LESS_EQUAL : '<=' ;

// 特殊操作符
BINDING_OPERATOR : ':=' ;
ALIAS_OPERATOR : ':' ;
SIGNATURE_JOIN : '++' ;
RETURN_TYPE : '->' ;
REFERENCE : '&' ;
CHANNEL_IN : '<-' ;


// 关键字
IF : 'if' ;
ELSE : 'else' ;
FOR : 'for' ;
WHILE : 'while' ;
FUNC : 'func' ;
RETURN : 'return' ;
IMPORT : 'import' ;
MAP : 'map' ;
STRUCT : 'struct' ;
TRY : 'try' ;
CATCH : 'catch' ;
RAISE : 'raise' ;
CHAN : 'chan' ;
BREAK : 'break' ;
CONTINUE : 'continue' ;
GOTO : 'goto' ;

// 标识符
IDENTIFIER : [\u4E00-\u9FFFa-zA-Z_] [\u4E00-\u9FFFa-zA-Z_0-9]* ;

// 单行注释
LINE_COMMENT : '#' ~[\r\n]* -> skip ;

// 多行注释
BLOCK_COMMENT : '##' .*? '##' -> skip ;

// 空白符
WS : [ \t\r\n]+ -> skip ;

// 错误处理
ERROR : . ;

// 括号
LPAREN  : '(' ;
RPAREN  : ')' ;

LBRACK  : '[' ;
RBRACK  : ']' ;

LBRACE  : '{' ;
RBRACE  : '}' ;

//数组
array        : fixed_array | dynamic_array ;

TYPE 
    : 'int8'
    | 'int16'
    | 'int32'
    | 'int64'
    | 'float8'
    | 'float16'
    | 'float32'
    | 'float64'
    | 'string'
    | 'bytes'
    | IDENTIFIER;


fixed_array  : TYPE LBRACK NUMBER RBRACK ;  // 类型[大小]，固定大小数组

dynamic_array: TYPE LBRACK RBRACK ;         // 类型[]，动态数组

literal      :LPAREN TYPE RPAREN NUMBER  ;
statement
    : assignment
    | functionDef
    | structDef
    | loop
    | selection
    | expr ';'
    | exceptionHandling
    ;

assignment
    : ID '=' expr ';'
    ;

functionDef
    : 'func' ID '(' paramList? ')' returnType? '{' statement* '}'
    ;

paramList
    : param (',' param)*
    ;

param
    : type ID
    ;

returnType
    : '->' type
    ;

structDef
    : 'struct' ID '{' fieldList '}'
    ;

fieldList
    : field (',' field)*
    ;

field
    : type ID
    ;

loop
    : 'for' '(' ID 'in' range ')' '{' statement* '}'
    ;

selection
    : 'if' '(' expr ')' '{' statement* '}' ( 'else' '{' statement* '}' )?
    ;

exceptionHandling
    : 'try' '{' statement* '}' 'catch' ('Exception' | 'catch') '{' statement* '}'
    ;

expr
    : ID
    | INT
    | FLOAT
    | STRING
    | '(' expr ')'
    | expr op=('*'|'/') expr
    | expr op=('+'|'-') expr
    | expr op=('=='|'!='|'<'|'>') expr
    | expr '&&' expr
    | expr '||' expr
    | '!' expr
    | ID '.' ID  // struct.field
    ;
int 
    : 'int8'
    | 'int16'
    | 'int32'
    | 'int64'
    ;
primitiveType
    : 'int8'
    | 'int16'
    | 'int32'
    | 'int64'
    | 'float8'
    | 'float16'
    | 'float32'
    | 'float64'
    | 'string'
    | 'bytes'
    ;

// 语法规则
expression
    : term (BIT_AND term)*   // 处理位与
    | term (BIT_OR term)*    // 处理位或
    | int (RIGHT_SHIFT int)* //处理右移操作符
    | REFERENCE term        // 处理单目运算符
    | term.BOOLEAN (LOGICAL_XOR term.BOOLEAN)* //处理逻辑异或
    | 
    ;
term
    : NUMBER                 // 数字
    | ID                     // 标识符
    | '(' expression ')'     // 括号中的表达式
    | FUNC                   // 函数
    | BOOLEAN                // 布尔值
    ;
reference
    : REFERENCE term         // 单目运算符
    ;

bitwiseExpression
    : term (BIT_AND term)*   // 双目运算符
    ;


range
    : expr 'to' expr
    ;



ID      : [a-zA-Z_] [a-zA-Z_0-9]* ;
INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]* ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;
