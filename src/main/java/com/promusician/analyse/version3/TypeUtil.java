package com.promusician.analyse.version3;


import java.lang.reflect.Field;

public class TypeUtil {
    public static final int KEYWORD=1;
    public static final int MUSICWORD=2;
    public static final int MUSICFUNCWORD=3;
    private final String keyWords[] = { "abstract", "boolean", "break", "byte",
            "case", "catch", "char", "class", "continue", "default", "do",
            "double", "else", "extends", "final", "finally", "float", "for",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected",
            "public", "return", "short", "static", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while","strictfp","enum","goto","const","assert" }; // 关键字数组
    private final char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&', '|',
            '!' }; // 运算符数组
    private final char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_',
            ':', '.', '"','\\'}; // 界符数组
    //音乐类
    private final String MusicWords[]={"Metronome","Tips","Tempo","Times","Snare","FloorTom","HiHat","Kick","Crash","LeftTom","RightTom"};
    //音乐函数
    private final String MusicFuncWords[]={"setBeat","setBPM","setTempo"};


    /**
     * 判断是否为字母
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    /**
     * 判断是否为数字
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isDigit(char ch) {

        return Character.isDigit(ch);
    }
    public int whichKeyWord(String s){
        if (isKeyWord(s))
            return TypeUtil.KEYWORD;
        else if (isMusicWord(s))
            return TypeUtil.MUSICWORD;
        else if (isMusicFuncWord(s))
            return TypeUtil.MUSICFUNCWORD;
        return 0;
    }
    /**
     * 判断是否为关键字
     * @param s 需判断的字符串
     * @return boolean
     */
    public boolean isKeyWord(String s) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].equals(s))
                return true;
        }
        return false;
    }

    /**
     * 判断是不是音乐类关键字
     * @param s
     * @return
     */
    public boolean isMusicWord(String s){
        for (int i = 0; i < MusicWords.length; i++) {
            if (MusicWords[i].equals(s))
                return true;
        }
        return false;
    }

    /**
     * 判断是不是音乐类函数关键字
     * @param s
     * @return
     */
    public boolean isMusicFuncWord(String s){
        for (int i = 0; i < MusicFuncWords.length; i++) {
            if (MusicFuncWords[i].equals(s))
                return true;
        }
        return false;
    }

    /**
     * 判断是否为运算符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isOperator(char ch) {
        for (int i = 0; i < operators.length; i++) {
            if (ch == operators[i])
                return true;
        }
        return false;
    }

    /**
     * 判断是否为分隔符
     * @param ch 需判断的字符
     * @return boolean
     */
    public boolean isSeparators(char ch) {
        for (int i = 0; i < separators.length; i++) {
            if (ch == separators[i])
                return true;
        }
        return false;
    }
    /**
     * 利用反射获取种别编码
     * @param args 属性名称
     * @return	种别编码
     */
    public int getType(String args) {
        int type = -1;
        Field[] fields = KeyTypes.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(args)) {
                try {
                    type = (Integer) field.get(new KeyTypes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return type;
    }

}
