package com.company.thread;

class SharedObject {
    static int number = 10;

    public void plus() {
        for(int i = 0; i < 10; i++) {
            number += 20;
            System.out.println(number);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void minus() {
        for(int i = 0; i < 10; i++) {
            number -= 20;
            System.out.println(number);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadExam3 extends Thread {
    int type;
    SharedObject sharedObject;

    public ThreadExam3(int type, SharedObject sharedObject){
        this.type = type;
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        switch (type){
            case 1: sharedObject.plus();
            case 2: sharedObject.minus();
        }
    }
}

public class SharedObjectTest1 {
    public static void main(String[] args) {
        SharedObject s1 = new SharedObject();

        ThreadExam3 t1 = new ThreadExam3(1, s1);
        ThreadExam3 t2 = new ThreadExam3(2, s1);

        t1.start();
        t2.start();
    }
}

/*
* number 값이 실행할 때마다 다름
* */