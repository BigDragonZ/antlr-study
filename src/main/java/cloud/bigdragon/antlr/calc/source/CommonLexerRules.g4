lexer grammar CommonLexerRules;  // 注意此处grammar前面多了lexer前缀

ID: [a-zA-Z]+ ; // 匹配标识符
INT: [0-9]+; // 匹配正式
NEWLINE: '\r'?'\n'; // 告诉语法分析器一个新行的开始  即语句终止标志
WS: [\t]+ -> skip; // 丢弃空白字符