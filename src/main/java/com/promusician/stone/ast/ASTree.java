package com.promusician.stone.ast;

import com.promusician.stone.env.Environment;

import java.util.Iterator;

public abstract class ASTree implements Iterable<ASTree>{
    public abstract ASTree child(int i);//返回第i个子节点
    public abstract int numChildren();//返回子节点的个数（叶子节点返回0）
    public abstract Iterator<ASTree> children();//（子节点iterator）
    public abstract String location();//返回AST节点在程序内所处位置的字符串
    public Iterator<ASTree> iterator(){//适配器，把ASTree类转为Iterable类型
        return children();
    }
    public abstract Object eval(Environment env);
}
