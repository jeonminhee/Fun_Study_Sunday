package com.company.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class Stream08 {
    public static void main(String[] args) {

        /* reduce 예제 */
        Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum3 = numbers3.reduce(10, (total, n) -> total + n); // 10 + 1 + 2 + 3 ...
        System.out.println("sum3: " + sum3);

    }
}
