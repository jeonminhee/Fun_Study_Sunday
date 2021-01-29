package com.company.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream06 {
    public static void main(String[] args) {
        IntStream charStream = "12345".chars();
        charStream.mapToObj(ch -> ch-'0').forEach(System.out::println);

        /*
         참고 : https://2atom.tistory.com/53
        */

        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream
                .flatMap(line->Stream.of(line.split(" +")));
        strStream.forEach(System.out::println);
    }
}
