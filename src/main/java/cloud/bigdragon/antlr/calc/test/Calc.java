package cloud.bigdragon.antlr.calc.test;

import cloud.bigdragon.antlr.calc.source.EvalVisitor;
import cloud.bigdragon.antlr.calc.source.LabeledExprLexer;
import cloud.bigdragon.antlr.calc.source.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Calc {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);
        LabeledExprLexer lexer = new LabeledExprLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);

    }
}
