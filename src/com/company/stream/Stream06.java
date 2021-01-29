package com.company.stream;

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

        DoubleStream doubleStream = DoubleStream.of(0.1, 0.3);
        OptionalDouble average = doubleStream.average();

        IntStream scoreStream = IntStream.of(1,2,3,4,5);
        IntSummaryStatistics stat = scoreStream.summaryStatistics();
        long totalCount = stat.getCount();
        long totalScore = stat.getSum();
        double avgScore = stat.getAverage();
        int minScore = stat.getMin();
        int maxScore = stat.getMax();
    }
}
