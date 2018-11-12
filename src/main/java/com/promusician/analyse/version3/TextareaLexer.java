package com.promusician.analyse.version3;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author LeesangHyuk
 * @version 3.0
 */

public class TextareaLexer extends TypeUtil{
    private StringBuffer buffer = new StringBuffer(); // 缓冲区
    private int i = 0;
    private char ch; // 字符变量，存放最新读进的源程序字符
    private String strToken; // 字符数组，存放构成单词符号的字符串

    public TextareaLexer(String code){
        try {
            buffer=StringUtil.readString(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analyse(){
        strToken = ""; // 置strToken为空串
        System.out.println(buffer.length());
        while (i < buffer.length()){
            getChar();
            getBC();
            if (isLetter(ch)){//如果ch是字母
                while (isLetter(ch) || isDigit(ch)) {
                    concat();
                    getChar();
                }
                retract(); // 回调
                switch (whichKeyWord(strToken)){
                    case 0:
                        getStrTokens("id",strToken);
                        break;
                    case 1:
                        getStrTokens("1:"+strToken,strToken);
                        break;
                    case 2:
                        getStrTokens("2:"+strToken,strToken);
                        break;
                    case 3:
                        getStrTokens("3:"+strToken,strToken);
                        break;
                }
                strToken = "";
            }else if (isDigit(ch)){
                while (isDigit(ch)) {//ch为数字
                    concat();
                    getChar();
                }
                if(!isLetter(ch)) {//不能数字+字母
                    retract(); // 回调
                    getStrTokens("digit",strToken);
                }else{
                    getStrTokens("error",strToken);
                }
                strToken = "";
            } else if (isOperator(ch)){
                if(ch == '/'){
                    getChar();
                    if(ch == '*') {//为/*注释
                        while(true){
                            getChar();
                            if(ch == '*'){// 为多行注释结束
                                getChar();
                                if(ch == '/') {
                                    getChar();
                                    break;
                                }
                            }
                        }
                    }
                    if(ch == '/'){//为//单行注释
                        while(ch != 9){
                            getChar();
                        }
                    }
                    retract();
                }
                switch (ch) {
                    case '+':  getStrTokens("plus",strToken);break;
                    case '-':  getStrTokens("min",strToken);break;
                    case '*':  getStrTokens("mul",strToken); break;
                    case '/':  getStrTokens("div",strToken); break;
                    case '>':  getStrTokens("gt",strToken);break;
                    case '<':  getStrTokens("lt",strToken);break;
                    case '=':  getStrTokens("eq",strToken); break;
                    case '&':  getStrTokens("and",strToken); break;
                    case '|':  getStrTokens("or",strToken); break;
                    case '~':  getStrTokens("not",strToken);break;
                    default:  break;
                }
            }else if(isSeparators(ch)){
                getStrTokens("separators",strToken);
            }else{
                getStrTokens("errors",strToken);
            }

        }
    }


    /**
     * 将下一个输入字符读到ch中，搜索指示器前移一个字符
     */
    public void getChar() {
//       System.out.println(ch);

        ch = buffer.charAt(i);
        i++;
    }
    /** 检查ch中的字符是否为空白，若是则调用getChar()直至ch中进入一个非空白字符*/
    public void getBC() {
        //isSpaceChar(char ch) 确定指定字符是否为 Unicode 空白字符。
        //上述方法不能识别换行符
        while (Character.isWhitespace(ch))//确定指定字符依据 Java 标准是否为空白字符。
            getChar();
    }

    /**将ch连接到strToken之后*/
    public void concat() {
        strToken += ch;
    }
    /** 将搜索指示器回调一个字符位置，将ch值为空白字 */
    public void retract() {
        i--;
        ch = ' ';
    }

    public void getStrTokens(String type,String str){
        //System.out.println("("+type+", "+str+")");
    }
}

