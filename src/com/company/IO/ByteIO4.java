package com.company.IO;

import java.io.*;

public class ByteIO4 {
    public static void main(String[] args) {
//        try(
//                DataOutputStream out = new DataOutputStream(new FileOutputStream("src/com/company/IO/data.txt"));
//        ){
//            out.writeInt(100);
//            out.writeBoolean(true);
//            out.writeDouble(50.5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try(
                DataInputStream in = new DataInputStream(new FileInputStream("src/com/company/IO/data.txt"));
                ){
            int i = in.readInt();
            boolean b = in.readBoolean();
            double d = in.readDouble();

            System.out.println(i);
            System.out.println(b);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

