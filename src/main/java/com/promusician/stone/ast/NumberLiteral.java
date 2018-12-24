package com.promusician.stone.ast;

import com.promusician.stone.env.Environment;
import com.promusician.stone.token.NumToken;
import com.promusician.stone.token.Token;

public class NumberLiteral extends ASTLeaf {
    public NumberLiteral(Token t) {
        super(t);
    }

    public int value() {
        return ((NumToken) token()).getValue();
    }

    @Override
    public Object eval(Environment env) {
        return value();
    }
}
