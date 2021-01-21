package com.company.thread;

public class ExtendThread extends Thread {
    String str;
    public ExtendThread(String str){
        this.str = str;
    }

    public void run(){
        for(int i = 0; i < 10; i ++){
            System.out.println(str);
            try {
                //thread 시작과 종료 사이에 랜덤하게 쉬었다가 출력할 수 있도록 sleep 메서드 사용
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
