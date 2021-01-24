package com.company.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIO1 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis(); //메소드 시작 시

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("src/com/company/IO/input1.txt");
            fos = new FileOutputStream("src/com/company/IO/output1.txt");

            int readData = -1; //input의 내용을 적을 변수

            //파일의 내용이 그대로 들어간 것이 아닌, 아스키값으로 변형되어 들어감
            while((readData = fis.read()) != -1){
//                System.out.println(readData);
//                //형변환을 해야 아스키값이 문자로 바뀜
//                System.out.println((char) readData);
                fos.write(readData);
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
