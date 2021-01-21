package com.company.thread;

public class ThreadExam2 {

    public static void main(String[] args) {
        ImplThread r1 = new ImplThread("*");
        ImplThread r2 = new ImplThread("-");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        System.out.println("Main End!");
    }
}
