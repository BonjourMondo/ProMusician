package com.promusician.analyse.version3;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StringUtil {

    public static StringBuffer readString(String code) throws IOException {
        StringBuffer stringBuffer=new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader
                (new ByteArrayInputStream(code.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        String temp=null;
        while((temp=br.readLine())!=null){
            //去注释
            String s="";
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i)=='/'&&temp.charAt(i+1)=='/'&&i+1<temp.length()){
                    break;
                }else{
                    s=s+temp.charAt(i);
                }
            }
            stringBuffer.append(s);
        }
        return stringBuffer;
    }
}

