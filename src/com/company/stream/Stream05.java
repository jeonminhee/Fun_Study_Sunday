package com.company.stream;

import java.io.File;
import java.util.stream.Stream;

public class Stream05 {
    public static void main(String[] args) {

        File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameString = fileStream.map(File::getName);
        filenameString.forEach(System.out::println);

        fileStream = Stream.of(fileArr); // 스트림을 다시 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .map(String::toUpperCase) // 모두 대문자로 변환
                .distinct() // 중복제거
                .forEach(System.out::println); // 출력

        System.out.println();
    }
}
