package com.company.anonymous;

interface Age {
    int age = 28;

    void getAge();
}

class MyClass implements Age {
    @Override
    public void getAge() {
        System.out.println("Age is " + age);
    }
}

public class AnonymousDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.getAge();
    }
}

/**
 * Age 인터페이스는 age 데이터와 getAge() 함수를 제공하고, MyClass는 Age를 구현받아서 작성한다.
 * 사실 여기서 프로그램이 끝난다면, MyClass를 따로 분리하여 작성할 필요가 없었을지도 모른다. 대신 다음과 같이 익명클래스로 단일 객체를 생성할 수 있다.
 */
