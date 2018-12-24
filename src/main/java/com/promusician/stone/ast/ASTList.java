package com.promusician.stone.ast;

import com.promusician.stone.Exception.StoneExcetion;
import com.promusician.stone.env.Environment;

import java.util.Iterator;
import java.util.List;

public class ASTList extends ASTree {
    protected List<ASTree> children;

    public ASTList(List<ASTree>lis){children=lis;}


    @Override
    public ASTree child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Iterator<ASTree> children() {
        return children.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('(');
        String seq="";
        for (ASTree t:children){
            sb.append(seq);
            seq=" ";
            sb.append(t.toString());
        }
        return sb.append(')').toString();
    }

    @Override
    public String location() {
        for (ASTree t:children){
            String s=t.location();
            if (s!=null){
                return s;
            }
        }
        return null;
    }

    @Override
    public Object eval(Environment env) {
        throw  new StoneExcetion("无法执行 eval "+toString(),this);
    }
}
