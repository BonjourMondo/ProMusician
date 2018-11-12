package com.promusician.service;

import com.promusician.analyse.version3.TextareaLexer;
import org.springframework.stereotype.Service;

@Service("analyserservice")
public class AnalyserServiceImpl implements AnalyserService {

    @Override
    public boolean analyseInputText(String str) {
        try {
            TextareaLexer lexer=new TextareaLexer(str);
            lexer.analyse();
        }catch (StringIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    @Override
    public String returnOutPutText(boolean b){
        if (b) {
            String s = "<div class=\"col-md-12\">\n" +
                    "                        <img class=\"\" style=\"height: 30px;width: 30px\" src=\"assets/images/proimage/kick.png\" alt=\"Kick\" onclick=\"img_kick();\">\n" +
                    "                        <span>RideCymbal r=new RideCymbal();</span>\n" +
                    "                    </div>\n" +
                    "\n" +
                    "                    <div class=\"col-md-12\">\n" +
                    "                        <img class=\"\" style=\"height: 30px;width: 30px\" src=\"assets/images/proimage/crash.png\" alt=\"Kick\" onclick=\"img_crash();\">\n" +
                    "                        <span>RideCymbal r=new RideCymbal();</span>\n" +
                    "                    </div>";
            return s;
        }else{
            return "false";
        }
    }
}
