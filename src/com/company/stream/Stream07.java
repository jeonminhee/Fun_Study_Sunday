package com.company.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class Stream07 {
    public static void main(String[] args) {

        /* reduce 예제 1 */
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = numbers.reduce((x, y) -> x + y);  // 1 + 2 + 3 + 4 + ...
        sum.ifPresent(s -> System.out.println("sum: " + s));

        /* 함수를 정의하지 않고 Integer::sum 을 사용해도 위와 동일한 결과를 출력한다. */
        Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum2 = numbers2.reduce(Integer::sum);
        sum2.ifPresent(s -> System.out.println("sum2: " + s));
    }
}
