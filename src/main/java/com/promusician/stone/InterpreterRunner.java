package com.promusician.stone;

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
import java.util.Iterator;

public class InterpreterRunner {
    private static String file = "E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\resources\\data\\lex.stone";
    public static Logger logger= LoggerFactory.getLogger(InterpreterRunner.class);

    public static void main(String[] args) {
        run(new BasicParser(), new BasicEnv(), file);
    }

    public static ArrayList<String> run(BasicParser basicParser, Environment basicEnv, String path) {
        ArrayList<String> strings=new ArrayList<>();
        try {
            Lexer lex = new Lexer(new FileReader(new File(path)));
            while (lex.peek(0) != Token.EOF) {
                ASTree ast = basicParser.parse(lex);
               // System.out.println(ast.toString(strings));
                if (!(ast instanceof NULLStmnt)) {
                    Object o = ast.eval(basicEnv,strings);
                    System.out.println("=> "+o);
                }
            }
            System.out.println(strings);
            return strings;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
