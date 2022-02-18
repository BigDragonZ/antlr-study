package cloud.bigdragon.antlr.arrayinit.test;

import cloud.bigdragon.antlr.arrayinit.source.ArrayInitBaseListener;
import cloud.bigdragon.antlr.arrayinit.source.ArrayInitParser;

// 将类似{1,2,3}的short数组初始化语句翻译为"\u0001\u0002\u0003"
public class ShortToUnicodeString extends ArrayInitBaseListener {
    //    将 { 翻译为 "
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    //    将 } 翻译为 "
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

//    将整数翻译为十六进制 加前缀
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
//        此处假设不存在嵌套结构
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
