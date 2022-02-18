package cloud.bigdragon.antlr.expr.test;

import cloud.bigdragon.antlr.expr.source.ExprLexer;
import cloud.bigdragon.antlr.expr.source.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExprTest {
    public static void main(String[] args) throws Exception {
//       创建字符输入流
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
//        创建词法分析器和语法分析器
        ANTLRInputStream input = new ANTLRInputStream(is);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        启动语法分析器
        ExprParser parser = new ExprParser(tokens);
//        从prog规则开始进行语法分析
        ParseTree tree = parser.prog();
//        以文本形式打印树
        System.out.println(tree.toStringTree(parser));
    }
}
