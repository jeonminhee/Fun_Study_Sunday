package com.company.thread;

class SharedObject2 {
    int number = 10;

    public synchronized void plus() {
        for(int i = 0; i < 10; i++) {
            number += 20;
            System.out.println(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 동기화 메소드

    public void minus() {
        for(int i = 0; i < 10; i++) {
            synchronized(this){
                number -= 20;
                System.out.println(number);
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// 동기화 블록, 동기화 메소드의 길이가 너무 길어 실행 시간이 느려질 경우, 필요한 부분만 동기화 해서 사용할 수 있음.

class ThreadExam4 extends Thread {
    int type;
    SharedObject2 sharedObject;

    public ThreadExam4(int type, SharedObject2 sharedObject){
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

public class SharedObjectTest2 {
    public static void main(String[] args) {
        SharedObject2 s1 = new SharedObject2();

        ThreadExam4 t1 = new ThreadExam4(1, s1);
        ThreadExam4 t2 = new ThreadExam4(2, s1);

        t1.start();
        t2.start();
    }
}

/*
* t1의 plus 메소드가 먼저 실행된 뒤 minus 메소드가 실행됨
* */