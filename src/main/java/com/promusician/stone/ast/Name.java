package com.promusician.stone.ast;

import com.promusician.stone.Exception.StoneExcetion;
import com.promusician.stone.env.Environment;
import com.promusician.stone.token.Token;

public class Name extends ASTLeaf {

    public Name(Token t) {
        super(t);
    }

    public String name() {
        return token().getText();
    }

    @Override
    public Object eval(Environment env) {
        Object value=env.get(name());
       if (value==null)
           throw new StoneExcetion("未定义的名字： "+name(),this);
       else
           return value;
    }
}
