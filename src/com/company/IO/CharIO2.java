package com.company.IO;

import java.io.*;

public class CharIO2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            br = new BufferedReader(new FileReader("src/com/company/IO/input2.txt"));
            pw = new PrintWriter(new FileWriter("src/com/company/IO/output2.txt"));
            String line = null;
            while((line = br.readLine())!= null){
                pw.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
}
