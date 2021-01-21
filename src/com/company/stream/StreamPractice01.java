package com.company.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPractice01 {

    /* 문자열 배열을 List에 저장 */
    String[] strArr = {"aaa", "ddd", "ccc"};
    List<String> strList = Arrays.asList(strArr);

    /* 두 데이터소스를 기반으로 하는 Stream 생성 */
    Stream<String> strStream1 = strList.stream(); // 스트림 생성
    Stream<String> strStream2 = Arrays.stream(strArr); // 스트림 생성

}
