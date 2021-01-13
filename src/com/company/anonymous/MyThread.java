package com.company.anonymous;

public class MyThread {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        });

        t.start();

        System.out.println("Main Thread");
    }
}

/**
 * 흔하게 사용하는 Thread를 익명 클래스로 구현한 것.
 * t를 Thread의 객체라고 생각 할 수 있겠지만 Thread 클래스를 확장한 익명 클래스의 객체이다.
 */