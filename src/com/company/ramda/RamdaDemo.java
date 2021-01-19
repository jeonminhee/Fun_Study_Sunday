package com.company.ramda;

public class RamdaDemo {

    public static void main(String[] args) {
        // 인터페이스를 구현한 익명 클래스의 객체
        Myfunction f = new Myfunction() {
            public int max(int a, int b){
                return a > b ? a : b;
            }
        };

        // 위의 객체를 함수형으로 변환, 람다식
        Myfunction ramDa_f = (a, b) -> a > b ? a : b;
    }

}
