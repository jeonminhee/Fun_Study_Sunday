package com.company.OOP;

interface Animal1{
public void eat();
public void fly();
public void swimming();
}


class Fish1 implements Animal1{
    public void eat() {
        System.out.println("물고기 먹는다");
    }

    public void fly() {
        System.out.println("물고기 난다?");
    }

    public void swimming() {
        System.out.println("물고기 수영한다");
    }

}

class Bird1 implements Animal1{

    public void eat() {
        System.out.println("새 먹는다");
    }

    public void fly() {
        System.out.println("새 난다");
    }

    public void swimming() {
        System.out.println("새 수영한다?");
    } //필요 없음!
}


public class ISPExam1 {
}
