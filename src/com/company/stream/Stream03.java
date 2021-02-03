package com.company.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Stream03 {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
        // strStream.sorted().forEach(System.out::println);

        /*
        결과 : CCaaabccdd
        */
        // strStream.sorted().forEach(System.out::println); // 기본정렬
        // strStream.sorted(Comparator.naturalOrder()).forEach(System.out::println); // 기본정렬
        // strStream.sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println); // 람다식도 가능

        /*
        결과 : ddccbaaaCC
        */
        // strStream.sorted(Comparator.reverseOrder()).forEach(System.out::println); // 기본정렬의 역순
        // strStream.sorted(Comparator.<String>naturalOrder().reversed()).forEach(System.out::println);
        // strStream.sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println); // 람다식 역순

        /*
        결과 : aaabCCccdd
        */
        // strStream.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println); // 대소문자 구분 안함

        /*
        결과 : ddCCccbaaa
        */
        // strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::println); // 대소문자 구분 안함

        /*
        결과 : bddCCccaaa
        */
        // strStream.sorted(Comparator.comparing(String::length)).forEach(System.out::println); // 길이 순 정렬
        // strStream.sorted(Comparator.comparingInt(String::length)).forEach(System.out::println); // no 오토박싱

        /*
        결과 : aaaddCCccb
        */
        // strStream.sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
    }
}
