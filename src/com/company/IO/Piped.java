package com.company.IO;

import java.io.*;

public class Piped {

    public static void main(String[] args) throws IOException {
        //기본 생성자를 이용해 PipedStream을 만들면 connect를 해줘야 함
//        PipedReader pr = new PipedReader();
//        PipedWriter pw = new PipedWriter();
//
//        pr.connect(pw);

        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter(pr);

        Thread t1 = new Thread1(pw);
        Thread t2 = new Thread2(pr);

        t2.start();
        t1.start();
    }
}

class Thread1 extends Thread {

    PipedWriter pWriter;

    public Thread1(PipedWriter pWriter) {
        this.pWriter = pWriter;
    }

    @Override
    public void run() {
        PrintWriter pw = new PrintWriter(pWriter);
        pw.println("loginFail");
//        pw.println("loginOK");
        pw.flush();
    }
}

class Thread2 extends Thread {

    PipedReader pReader;

    public Thread2(PipedReader pReader) {
        this.pReader = pReader;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(pReader);
        String pMsg;
        try {
            pMsg = br.readLine();
            if(pMsg.equals("loginFail")) {
                System.out.println("로그인에 실패했으므로 쓰레드가 실행되지 않습니다");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("로그인에 성공했으므로 쓰레드가 정상적으로 실행됩니다");
        for(int i=0;i<10;i++) {
            System.out.printf("%d ",i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}