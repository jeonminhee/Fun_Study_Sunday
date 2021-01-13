package com.company.anonymous;

interface Age2 {
    int age = 28;

    void getAge();
}

public class AnnoymousDemoAfter {
    public static void main(String[] args) {
        /**
         * 람다식으로 변환
         */
        int age = 20;
        Age2 a2 = () -> System.out.println("Age is " + age);
        a2.getAge();

        /**
         * 익명클래스로 변환
         */
        Age2 a3 = new Age2() {
            @Override
            public void getAge() {
                System.out.println("Age is " + age);
            }
        };
        a3.getAge();
    }
}
