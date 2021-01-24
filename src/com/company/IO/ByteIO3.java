package com.company.IO;

import java.io.*;

public class ByteIO3 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis(); //메소드 시작 시간

        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream("src/com/company/IO/input1.txt");
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream("src/com/company/IO/output1.txt");
            bos = new BufferedOutputStream(fos);

            int readData = -1; //input의 내용을 적을 변수

            //파일의 내용이 그대로 들어간 것이 아닌, 아스키값으로 변형되어 들어감
            while((readData = bis.read()) != -1){
//                System.out.println(readData);
//                System.out.println((char) readData);

                bos.write(readData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms"); //메소드 실행 시간
    }
}
