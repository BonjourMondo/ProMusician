package com.promusician.analyse.version2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 文件操作
 * @author zhangyu
 */
public class FileUtil {
    /**
     * 文件读取到缓冲区
     * @param buffer 缓冲区
     * @param fileSrc 文件路径
     * @return true : success
     * 		   false : filed
     */
    public static boolean readFile(StringBuffer buffer, String fileSrc) {
        try {
            FileReader fileReader = new FileReader(fileSrc);
            BufferedReader br = new BufferedReader(fileReader);
            String temp = null;
            while ((temp = br.readLine()) != null) {
                //去注释
                String s="";
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i)=='/'&&temp.charAt(i+1)=='/'&&i+1<temp.length()){
                       break;
                    }else{
                        s=s+temp.charAt(i);
                    }
                }
//                System.out.println(s);
                buffer.append(s);
//                System.out.println(temp);
//                buffer.append(temp);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 追加方式写文件
     * @param args	需要写入字符串
     * @return	true : success
     * 		   false : filed
     */
    public static boolean writeFile(String args) {
        try {
            File file = new File("E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\java\\com\\promusician\\analyse\\output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(args);
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }
    /**
     * 清空文件
     */
    public static boolean clearFile() {
        try {
            File file = new File("E:\\BounjourMonde\\SpringMVC\\ProMusician\\src\\main\\java\\com\\promusician\\analyse\\output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void ignore(String temp){
        String s="";
        for (int i = 0; i < temp.length()-1; i++) {
            if (temp.indexOf(i)=='/'&&temp.indexOf(i+1)=='/'){
                return;
            }else{
                s+=temp.indexOf(i);
            }
        }
    }
}
