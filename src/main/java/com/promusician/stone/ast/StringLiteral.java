package com.promusician.stone.ast;

import com.promusician.stone.env.Environment;
import com.promusician.stone.token.Token;

public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token t) {
        super(t);
    }

    public String value() {
        return token().getText();
    }

    @Override
    public Object eval(Environment env) {
        return value();
    }
}
