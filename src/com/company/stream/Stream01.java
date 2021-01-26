package com.company.stream;

import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {

        /* 스트림 연산의 반환타입 */

        String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
        Stream<String> stream           = Stream.of(strArr); // 문자열 배열이 소스인 스트림
        Stream<String> filteredStream   = stream.filter(x -> x.length() != 0); // 걸러내기 (중간연산)
        Stream<String> distinctStream = stream.distinct(); // 중복제거 (중간연산)
        Stream<String> sortedStream     = stream.sorted(); // 정렬 (중간연산)
        Stream<String> limitedStream    = stream.limit(4); // 스트림 자르기 (중간연산)
        long           total            = stream.count(); // 요소 개수 세기 (최종연산)

        /*
        distinct()                       : 중복을 제거
        filter(Predicate<T> predicate)   : 조건에 안맞는 요소 제외
        limit(long maxSize)              : 스트림의 일부를 잘라낸다
        skip(long n)                     : 스트림의 일부를 건너뛴다
        peek(Consumer<T> action)         : 스트림의 요소에 작업수행
        sorted()                         : 스트림의 요소를 정렬한다.
        sorted(Comparator<T> comparator) : 스트림의 요소를 정렬한다.
        map(), flatMap()                 : 스트림의 요소를 변환한다,
        ... 이외의 여러가지가 있다.
        */

    }

}
