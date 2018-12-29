package com.promusician.stone.Exception;

import com.promusician.stone.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ParseException extends RuntimeException {
    public static Logger logger= LoggerFactory.getLogger(ParseException.class);
    private static final long serialVersionUID = 8076082103334818137L;

    public ParseException(String msg, Token t){
        super("在 "+location(t)+" 有语法错误 "+msg);
        logger.debug("在 "+location(t)+" 有语法错误 "+msg);
    }

    private static String location(Token t) {
        if (t==Token.EOF){
            return "最后一行";
        }
        return "第"+t.getLineNumber()+"行:"+t.getText();
    }

    public ParseException(Token t){
        this("",t);
    }

    public ParseException(IOException e){
        super(e);
    }
    public ParseException(String msg){
        super(msg);
    }
}
