package com.company.anonymous;

public class DefaultThread extends Thread {
    /**
     * 가장 기본적인 Thread 사용 예제
     */
    @Override
    public void run() {
        System.out.println("Child Thread");
    }

    public static void main(String[] args) {
        DefaultThread dt = new DefaultThread();
        dt.start();

        System.out.println("Main Thread");
    }
}
