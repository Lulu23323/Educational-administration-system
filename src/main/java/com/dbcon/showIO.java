package com.dbcon;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class showIO {

    public static void writeHistory (String str) throws IOException {
        File file = new File("d:"+File.separator+"editHistory.txt");
        OutputStream fos = new FileOutputStream(file,true);
        Date date = new Date();
        str = str + " Create Time: "+date+"\r\n";
        fos.write(str.getBytes(StandardCharsets.UTF_8));
        fos.close();

    }

    public static void writeId (String str) throws IOException {
        File file = new File("d:"+File.separator+"studentID.txt");
        OutputStream fos = new FileOutputStream(file,true);
        Date date = new Date();
        str = str + " Login Time: "+date+"\r\n";
        str = str + "\r\n";
        fos.write(str.getBytes(StandardCharsets.UTF_8));
        fos.close();

    }

    public static String readHistory() throws IOException {
        File file = new File("d:"+File.separator+"editHistory.txt");
        //check if null
        if(!file.exists()){
            return null;
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String str = new String(bytes,StandardCharsets.UTF_8);
        return str;
    }

    public static String readId() throws IOException {
        File file = new File("d:"+File.separator+"studentId.txt");
        //check if null
        if(!file.exists()){
            return null;
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String str = new String(bytes,StandardCharsets.UTF_8);
        String [] array = str.split("\r\n");
        int i = array.length-1;
        str = array[i];
        return str;

    }

    public static String combine(String str){
        String [] array = str.split("\r\n");
        String s="";
        for (int i=0;i<array.length;i++){
            s=s+array[i];
        }
        return s;
    }


}
