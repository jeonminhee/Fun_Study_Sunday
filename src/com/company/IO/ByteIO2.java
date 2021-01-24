package com.company.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIO2 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis(); //메소드 시작 시

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("src/com/company/IO/input1.txt");
            fos = new FileOutputStream("src/com/company/IO/output1.txt");

            int readData = -1; //input의 내용을 적을 변수
            byte[] buffer = new byte[512];

            //파일의 내용이 그대로 들어간 것이 아닌, 아스키값으로 변형되어 들어감
            while((readData = fis.read()) != -1){
                fos.write(buffer, 0, readData);
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
