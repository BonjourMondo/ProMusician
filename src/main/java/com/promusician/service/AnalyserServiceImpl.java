package com.promusician.service;

import com.promusician.stone.Lexer;
import com.promusician.stone.token.Token;
import org.springframework.stereotype.Service;

@Service("analyserservice")
public class AnalyserServiceImpl implements AnalyserService {

    @Override
    public String analyseInputText(String str) {
        Lexer lexer = new Lexer(str);
        String responseText="";

        int i=0;
        for (Token t; (t = lexer.read()) != Token.EOF; ) {
            if (t.getLineNumber()>i) {
                i=t.getLineNumber();
                responseText += "<span id=\""+i+"\">"+i + "</span>";
            }
            if (t.getText().equalsIgnoreCase("\\n"))
                responseText+="<br/>";
            else if (t.getText().equalsIgnoreCase("bpm"))
                responseText+="<span style=\"color:#F00\">BPM </span>";
            else if (t.getText().equalsIgnoreCase("rhy"))
                responseText+="<span style=\"color:#F00\">RHY </span>";
            else if (t.getText().equalsIgnoreCase("while"))
                responseText+="<span style=\"color:#F00\">WHILE </span>";
            else if (t.getText().equalsIgnoreCase("times"))
                responseText+="<span style=\"color:#F00\">TIMES </span>";
            else if(t.getText().equalsIgnoreCase("{"))
                responseText+="<span style=\"color:#F00\">{</span>";
            else if (t.getText().equalsIgnoreCase("}"))
                responseText+="<br><span style=\"color:#F00\">}</span>";
            else if(t.getText().equalsIgnoreCase("if"))
                responseText+="<span style=\"color:#F00\">IF </span>";
            else if (t.getText().equalsIgnoreCase("else"))
                responseText+="<span style=\"color:#F00\">ELSE </span>";
            else {
                responseText=responseText+t.getText()+judgeInstrument(t.getText());
            }
           }

        responseText+="<span id='1s' style=\"color:#F00\">ELSE </span>";
        return  responseText;
    }

    public String judgeInstrument(String s){
        //"sn"|"fl"|"hi"|"bi"|"sm"|"ki"|"cr"
        switch (s){
            case "cr":
                return ":Crash-Cymbol";
            case "hi":
                return ":Hi-Hat";
            case "ki":
                return ":Kick-Drum";
            case "fl":
                return ":Floor-Tom";
            case "sn":
                return ":Snare-Drum";
            case"sm":
                return ":Small-Rack";
            case "bi":
                return ":Big-Rack";
            default:
                return "";
        }
    }

}
