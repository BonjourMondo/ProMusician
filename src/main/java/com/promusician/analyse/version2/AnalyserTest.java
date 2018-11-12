package com.promusician.analyse.version2;

@Deprecated
public class AnalyserTest {
    public static void main(String[] args) {
		/*创建词法分析类*/
        TestLexer testLexer = new TestLexer("E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\java\\com\\promusician\\analyse\\input.txt");
        FileUtil.clearFile();//清空文件
        testLexer.analyse();
    }

}
