# 메서드 참조

> 메서드 참조란?
- 람다식이 하나의 메서드만 호출하는 경우 사용가능
- 람다식을 더 간결하게 표현
```java
// 문자열을 정수로 변환하는 람다식
Function<String, Integer> f = (String s) -> Integer.parseInt(s);
/*
Function<T,R> 함수형 인터페이스
- apply라는 메서드가 존재
- T를 인자로 받고 R을 리턴한다.
*/
```

```java
// 위의 람다식을 메서드로 표현
Integer wrapper(String s) {
	return Integer.parsInt(s);
}
```
* wrapper 메서드는 그저 값을 받아서 Integer.parseInt()에게 넘겨주는 일만 하기 때문에, Integer.ParseInt()를 직접 호출하는게 낫다.
```java
// 메서드 참조로 변경 전
Function<String, Integer> f = (String s) -> Integer.parseInt(s);
// 메서드 참조로 변경 후
Funtion<String, Integer> f = Integer::parseInt;
```

#### 예제
```java
// 메서드 참조로 변경 전
BiFunction<String, String, Boolean> f = (s1, s2) -> s1.equals(s2);
// 메서드 참조로 변경 후
BiFunction<String, String, Boolean> f = Stirng::equals;
/*
BiFunction<T, U, R> 함수형 인터페이스
- 앞의 두개의 타입(T, U)으로 인자를 받고 3번째 타입(R)으로 리턴한다.
- apply라는 메서드가 존재
*/
```
