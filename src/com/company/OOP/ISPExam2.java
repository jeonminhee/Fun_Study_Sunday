package com.company.OOP;

interface Animal2{
public void eat();
}

interface Fish2 {
    public void swimming();
}

interface Bird2 {
    public void fly();
}


class Mullet implements Animal2, Fish2{

    public void eat() {
        System.out.println("물고기 먹는다");
    }

    public void swimming() {
        System.out.println("물고기 수영한다");
    }

}

class Parrot implements Animal2, Bird2{

    public void eat() {
        System.out.println("새 먹는다");
    }

    public void fly() {
        System.out.println("새 난다");
    }
}


public class ISPExam2 {
}
