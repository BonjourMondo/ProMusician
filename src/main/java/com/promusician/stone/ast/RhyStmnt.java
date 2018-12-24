package com.promusician.stone.ast;

import com.promusician.stone.env.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RhyStmnt extends ASTList {

    public RhyStmnt(List<ASTree> lis) {
        super(lis);
    }

    public int length(){
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList("cr","sn","fl","hi","bi","sm", "ki"));

        int j=0;
        for (int i = 0; i < real_length(); i++) {
            if (child(i) instanceof ASTList) {
                for (int k = 0; k < ((ASTList) child(i)).children.size(); k++) {
                    if (arrayList.contains(child(i).child(k).toString())) {
                       // System.out.print(child(i).child(k).toString()+" ");
                        j++;
                    }
                }
//                j++;//有子节点的必然是某乐器
            }else {
                if (arrayList.contains(child(i).toString()))
                    j++;
            }
        }
        return j;
    }

    public int real_length(){
        return children.size();
    }

    public String toString() {
        return "(ryh {"+real_length()+" "+length()+"} )";
    }

    @Override
    public Object eval(Environment env) {
        return 0;
    }
}
