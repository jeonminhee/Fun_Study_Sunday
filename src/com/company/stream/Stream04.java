package com.company.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Stream04 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 280),
                new Student("감자바", 3, 180)

            );

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 기본 정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    // 총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
        /*
        현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
        현재 객체 == 파라미터로 넘어온 객체: 0 리턴
        현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
        음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
        */
    }
}
