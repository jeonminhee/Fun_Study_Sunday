package com.company.IO;

import java.io.*;

public class StringStream {
    public static void main(String[] args) throws IOException {
        String data = "DATA!";
        StringReader stringReader = new StringReader(data);
        StringWriter stringWriter= new StringWriter();

        int read;

        while ((read = stringReader.read()) != -1) {
            stringWriter.write(read);
        }

        //출력할 때에는 String로 바꿔줘야 함
        System.out.println(stringWriter.getClass());
        System.out.println(stringWriter.toString());

        //getBuffer메소드는 StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환함
        System.out.println(stringWriter.getBuffer().getClass());
        System.out.println(stringWriter.getBuffer().toString());

    }
}
