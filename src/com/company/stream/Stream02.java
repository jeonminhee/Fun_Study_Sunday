package com.company.stream;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Stream02 {

    public static void main(String[] args) {
        // limit()를 사용한 유한 스트림 생성
        IntStream intStream1 = new Random().ints();
        intStream1.limit(5).forEach(System.out::println);

        System.out.println("--------------------------");

        // 매개변수로 스트림 크기 지정
        IntStream intStream2 = new Random().ints(5);
        intStream2.forEach(System.out::println);

        System.out.println("--------------------------");

        // 지정된 범위의 난수를 발생시키는 무한 스트림
        IntStream intStream3 = new Random().ints(1,6);
        // intStream3.forEach(System.out::println);

        System.out.println("--------------------------");

        IntStream intStream4 = new Random().ints(5, 1,6);
        intStream4.forEach(System.out::println);

    }
}
