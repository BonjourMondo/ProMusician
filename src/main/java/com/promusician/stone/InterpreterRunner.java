package com.promusician.stone;

import com.promusician.stone.Exception.DeadLoopException;
import com.promusician.stone.Exception.ParseException;
import com.promusician.stone.Exception.StoneExcetion;
import com.promusician.stone.ast.ASTree;
import com.promusician.stone.ast.NULLStmnt;
import com.promusician.stone.ast.RhyStmnt;
import com.promusician.stone.env.BasicEnv;
import com.promusician.stone.env.Environment;
import com.promusician.stone.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class InterpreterRunner {
    private static String file = "E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\resources\\data\\lex.stone";
    public static Logger logger= LoggerFactory.getLogger(InterpreterRunner.class);

    public static void main(String[] args) {
        runFile(new BasicParser(), new BasicEnv(), file);
    }

    public static ArrayList<String> runFile(BasicParser basicParser, Environment basicEnv, String path) {
        ArrayList<String> strings=new ArrayList<>();
        try {
            Lexer lex = new Lexer(new FileReader(new File(path)));
            run(basicParser,basicEnv,lex,strings);
            System.out.println(strings);
//            System.out.println(strings.size());
//            System.out.println(strings.contains("loops"));
//            System.out.println(strings.get(strings.size()-1));
            return strings;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> runCode(BasicParser basicParser, Environment basicEnv, String code) {
        ArrayList<String> strings = new ArrayList<>();
        Lexer lex = new Lexer(code);
        run(basicParser,basicEnv,lex,strings);
        System.out.println(strings);
//            System.out.println(strings.size());
//            System.out.println(strings.contains("loops"));
//            System.out.println(strings.get(strings.size()-1));
        return strings;
    }

    public static void run(BasicParser basicParser, Environment basicEnv,Lexer lex,ArrayList arrayList){
        while (lex.peek(0) != Token.EOF) {
            ASTree ast = basicParser.parse(lex);
            // System.out.println(ast.toString(strings));
            if (!(ast instanceof NULLStmnt)) {
                try {
                    Object o = ast.eval(basicEnv, arrayList);
                } catch (DeadLoopException e) {
                    logger.debug(e.getMessage());
                    //出现死循环错误
                    //后期应当报到前端提醒？
                    break;
                } catch (StoneExcetion e) {
                    logger.debug(e.getMessage());
                    //出现语法错误
                    break;
                } catch (ParseException e) {
                    logger.debug(e.getMessage());
                    //出现词法错误
                    break;
                } catch (Exception e) {
                    logger.debug(e.getMessage());
                    //????
                    break;
                }
//                    System.out.println("=> "+o);
            }
        }
    }
}
