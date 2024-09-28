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
STRUCT: 'struct';
MAP: 'map';

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
DECLARE_ASSIGN: ':='; 
COLON: ':';
SEMI: ';';
COMMA: ',';
DOLLAR: '$';  
DOT: '.';  
LEFT_ARROW: '<-';
RIGHT_ARROW: '->';
AT: '@';



// 括号
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';  
RBRACK: ']';  
LBRACE: '{';
RBRACE: '}';

// 数据类型
BOOLEAN: TRUE | FALSE;
NUMBER: INT |FLOAT;
INT: [0-9]+;
FLOAT: [0-9]+('.' [0-9]+)?;

NEWLINE : ( '\r\n' | '\r' | '\n' )+ ; // 支持跨平台换行符

// 定义格式化字符串的占位符规则
fragment FORMAT_PLACEHOLDER
    : LBRACE ID RBRACE  // 占位符可以是标识符、数字或 '*'
    ;
fragment ESC_SEQ 
    : '\\' [btnrf"'\\]  // 支持常见的转义符 (\b, \t, \n, \r, \f, \', \", \\)
    | UNICODE_ESC       // 支持 Unicode 转义符
    ;

fragment UNICODE_ESC 
    : '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT  // 支持 Unicode 字符，比如 \u0041 表示 'A'
    ;

fragment HEX_DIGIT 
    : [0-9a-fA-F]  // 十六进制数字
    ;



// 允许的字符串内容
fragment STRING_CONTENT
    : ~["\\{}]+ | '\\' .   // 排除双引号、反斜杠和占位符
    ;

RAW_STRING
    : 'r' '"' ( . | NEWLINE )*? '"'       // 支持多行原始字符串（双引号）
    | 'r' '\'' ( . | NEWLINE )*? '\''      // 支持多行原始字符串（单引号）
    ;
STAND_STRING
    : '"' (~["\\] | '\\' .)* '"'    // 支持双引号包围的字符串
    | '\'' (~['\\] | '\\' .)* '\''  // 支持单引号包围的字符串
    ;
// 定义支持的格式化字符串（f开头）
FORMATSTRING
    : 'f' '"' (STRING_CONTENT | FORMAT_PLACEHOLDER)* '"'  // 双引号包围的格式字符串
    | 'f' '\'' (STRING_CONTENT | FORMAT_PLACEHOLDER)* '\''  // 单引号包围的格式字符串
    ;
// 词法分析器规则
STRING
    : STAND_STRING
    | RAW_STRING
    | FORMATSTRING
    ;
ID: [_a-zA-Z][a-zA-Z0-9_]*;
// 注释和空白字符
// 行注释：以 # 开头，到换行符结束，注释内容被忽略
LINE_COMMENT
    : '#' ~[\r\n]* -> skip
    ;

// 多行注释：以 // 开头，匹配到 // 结束，支持跨多行，注释内容被忽略
MULTILINE_COMMENT
    : '//' .*? '//' -> skip
    ;

WS: [ \t\r\n]+ -> skip;





// 语法分析器规则

numberType
    : intType
    | floatType
    ;
intType
    : 'int' | 'int8' | 'int16' | 'int32' | 'int64'
    ;
floatType
    : 'float' | 'float8' | 'float16' | 'float32' | 'float64' 
    ;
boolType: 'bool';
stringType: 'string';
literal
    : BOOLEAN          
    | NUMBER        
    | STRING        
    ;
basicType
    : numberType
    | boolType
    | stringType
    ;
type
    : basicType
    | ID
    | arrayType
    
    ;
// 语句分隔符规则
statementSeparator
    : SEMI        // 显式分号
    | NEWLINE    // 换行符作为分隔符
    ;
generalSeparator
    : statementSeparator
    | RBRACE
    ;

program
    : module EOF  // 程序由模块直到文件结束
    ;

module
    : (structDefinition         // 结构体定义
    | mapDeclaration         // map定义和初始化
    | variableAssignment        // 变量赋值
    | functionDefinition        // 函数定义
    )* mainFunctionDefinition?  // 主函数定义只能有 0 或 1 个
    ;
structDefinition
    : STRUCT ID LBRACE (structField)+ RBRACE
    ;

implStruct
    : LBRACE expression (COMMA expression)* RBRACE
    | expression
    ;

structField
    : type declaraction? generalSeparator
    | aliasDeclaration declaraction? generalSeparator
    ;


scope
    : LBRACE statement* RBRACE    // 作用域划分，以 {} 包围
    ;

// 单一的 statement 规则，包含各种语句类型
statement
    : ifStatement
    | forStatement
    | funcDeclaration
    | aliasDeclaration   // 别名声明
    | returnStatement
    | assignment
    | declarationStatement        // 海象符号声明
    ;

statements
    : statement statementSeparator  // 语句可以用分号或换行结束
    ;
reference
    : DOLLAR ID    // $ 标识符引用
    ;

// if 语句
ifStatement
    : IF expression COLON NEWLINE statements+ (elifStatement)* (elseStatement)?  
    | IF expression block (elifStatement)* (elseStatement)?  
    ;
elifStatement
    : ELIF expression block  // 可选的 elif 分支
    | ELIF expression COLON NEWLINE statements+
    ;
elseStatement
    : ELSE COLON NEWLINE statements+  // 可选的 else 分支
    | ELSE block
    ;

// for 循环语句
forStatement
    : FOR ID* IN expression COLON block  // 简化的 for-in 循环语法
    ;

keyValuePair
    : expression COMMA expression  // 键值对定义，键和值都为表达式
    ;
fixedArray
    : type LBRACK INT RBRACK  // 固定大小数组语法
    ;
dynamicArray
    : type LBRACK RBRACK  // 动态数组语法
    ;
arrayType
    : fixedArray
    | dynamicArray
    ;
literalArray
    : LBRACK paramList

signType: LT paramList? RIGHT_ARROW paramList? GT;

// 函数声明，支持函数签名
funcDeclaration
    : FUNC ID LPAREN paramList? RPAREN paramList? COLON block  // 函数定义，带参数列表和可选的返回类型
    ;

mapDeclaration
    : MAP (LT type COMMA type GT)? LBRACE keyValuePair* RBRACE  // 哈希表声明语法
    ;

// 别名声明，使用冒号定义别名
aliasDeclaration
    : ID COLON type
    ;

// return 语句
returnStatement
    : RETURN expression* generalSeparator  // return 语句，支持带或不带返回值和多返回值(隐式转化为匿名结构体)
    ;

// 赋值语句
assignAction
    : ASSIGN expression   // 简单的变量赋值
    ;
assignment
    : ID assignAction generalSeparator
    ;
// 声明语句（支持类型推断）
declaraction
    : DECLARE_ASSIGN expression   // 使用 := 进行声明和类型推断
    ;
declarationStatement
    : ID declaraction generalSeparator
    | aliasDeclaration declaraction generalSeparator
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
    : ID COLON typeSpecifier  
    | typeSpecifier
    ;

// 类型说明符
typeSpecifier
    : numberType
    | boolType
    | stringType
    | signType
    | ID  
    ;

// 表达式
expression
    : equalityExpression
    | relationalExpression
    | additiveExpression
    | multiplicativeExpression
    | funcCall
    | literal
    | primary
    | ID
    ;

// 函数调用表达式，支持别名调用
funcCall
    : ID LPAREN argumentList? RPAREN  
    | ID DOT funcCall
    | implStruct DOT funcCall
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
