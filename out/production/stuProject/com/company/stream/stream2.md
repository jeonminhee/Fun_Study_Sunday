# 스트림 (Stream) 심화

## 스트림이란?
> 스트림의 연산
#### 데이터 소스를 다루는 작업을 수행하는 것을 연산이라 한다.
* 중간연산과 최종연산으로 분류한다.
    * 중간연산 : 연산 결과가 스트림인 연산. 스트림에 연속해서 중간연산할 수 있음.
    * 최종연산 : 연산 결과가 스트림이 아닌 연산. 스트림의 요소를 소모하므로 단 한번만 가능.
```java
stream.distinct().limit(5).sorted().forEach(System.out::println);
/* 
distinct().limit(5).sorted() -> 중간연산
forEach(System.out::println) -> 최종연산
*/
```
* Stream01.java 파일 참조
* 중간연산은 map()과 flatMap(), 최종연산은 reduce()와 collect()가 핵심이다.

***

> 지연된 연산
#### 스트림은 최종연산이 수행되기 전 까지는 중간연산이 수행되지 않는다.
* 최종연산이 수행되어야 스트림의 요소들이 중간연산을 거쳐 최종연산에서 소모된다.
***
> Stream\<Integer>와 IntStream
#### IntStream, LongStream, DoubleStream과 같은 기본형으로 다루는 스트림을 제공한다.
* Stream\<Integer> 대신 IntStream을 사용하는 것이 더 효율적이다.
    * 오토박싱 & 언박싱으로 인한 비효율 문제
***
> 병렬스트림
#### 병렬 처리가 쉽다는게 스트림의 장점이다.
* 내부적으로 fork&join 프레임웍을 이용해서 자동적으로 연산을 병렬로 수행한다.
* paralle()를 호출하면 된다.
* paralle() 호출을 취소하기 위해서는 sequential()을 사용한다.
```java
int sum = strStream.parallel() // strStream을 병렬 스트림으로 전환
                   .mapToInt(s -> s.lenght())
                   .sum();
```
***
## 스트림 만들기
> 컬렉션
* Collection(컬렉션의 최고 조상)에는 stream()이 정의되어 있다.
> 배열

> 특정 범위의 정수

> 임의의 수

> 람다식

> 파일

> 빈 스트림

> 두 스트림의 연결