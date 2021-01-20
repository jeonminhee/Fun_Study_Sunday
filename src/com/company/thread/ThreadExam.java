package com.company.thread;

public class ThreadExam {

    public static void main(String[] args) {
        ExtendThread t1 = new ExtendThread("*");
        ExtendThread t2 = new ExtendThread("-");

        t1.start();
        t2.start();

        System.out.println("Main End!");
    }
}
