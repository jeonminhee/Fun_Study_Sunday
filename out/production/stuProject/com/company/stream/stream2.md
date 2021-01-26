# 스트림 (Stream) 심화

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