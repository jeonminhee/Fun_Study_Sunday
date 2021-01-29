package com.company.IO;

import java.io.*;

public class Print {
    public static void main(String[] args) throws IOException {
        // input4에 내용 입력
        PrintWriter printWriter = new PrintWriter("src/com/company/IO/input4.txt");

        printWriter.println("welcome!");
        printWriter.println("to!");
        printWriter.println("java!");
        printWriter.println("world!");

        printWriter.close();

        //input4에 입력된 내용 가져오기
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/company/IO/input4.txt"));

        String str;

        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }
}
