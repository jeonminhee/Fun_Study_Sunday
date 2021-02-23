package com.company.stream;

import java.util.stream.Stream;

public class Stream09 {
    public static void main(String[] args) {

        /* reduce 예제 */
        Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum4 = numbers4.parallel().reduce(0, (total, n) -> total + n); // ( 1 + 2 ) + ( 3 + 4 ) + ( 5 + 6 ) ...
        System.out.println("sum4: " + sum4);

    }
}
