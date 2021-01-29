package com.company.IO;

import java.io.*;


public class Sequencel {
    public static void main(String[] args) throws IOException {
        int read;
        byte[] arr = {32, 106, 97, 118, 97, 33};

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
        FileInputStream fileInputStream = new FileInputStream("src/com/company/IO/input3.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream, byteArrayInputStream);

        while((read = sequenceInputStream.read()) != -1) {
            System.out.println((char) read);
        }

    }
}
