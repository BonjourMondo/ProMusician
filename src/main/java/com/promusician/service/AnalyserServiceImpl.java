package com.promusician.service;

import com.promusician.stone.Lexer;
import com.promusician.stone.token.Token;
import org.springframework.stereotype.Service;

@Service("analyserservice")
public class AnalyserServiceImpl implements AnalyserService {

    @Override
    public String analyseInputText(String str) {
        Lexer lexer = new Lexer(str);
        String response="";

        for (Token t; (t = lexer.read()) != Token.EOF; ) {
            response+="<s>"+t.getLineNumber() + "</s>=> " + t.getText();
           // System.out.println(t.getLineNumber() + "=> " + t.getText()/*+" "+t.isIdentifier()+" "+t.isNumber()+" "+t.isString()*/);
        }
        return   response;
    }

}
