package com.promusician.stone;

import com.promusician.stone.ast.ASTree;
import com.promusician.stone.ast.NULLStmnt;
import com.promusician.stone.env.BasicEnv;
import com.promusician.stone.env.Environment;
import com.promusician.stone.token.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InterpreterRunner {
    private static String file = "E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\resources\\data\\lex.stone";

    public static void main(String[] args) {
        run(new BasicParser(), new BasicEnv(), file);
    }

    public static void run(BasicParser basicParser, Environment basicEnv, String path) {
        try {
            Lexer lex = new Lexer(new FileReader(new File(path)));
            while (lex.peek(0) != Token.EOF) {
                ASTree ast = basicParser.parse(lex);
                System.out.println(ast.toString());
                if (!(ast instanceof NULLStmnt)) {
                    Object o = ast.eval(basicEnv);
                    System.out.println("=> "+o);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
