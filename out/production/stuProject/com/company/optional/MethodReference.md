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
```java
MyClass obj = new MyClass();
// 메서드 참조로 변경 전
Function<String, Boolean> f = (x) -> obj.equals(x);
// 메서드 참조로 변경 후
Function<String, Boolean> f = obj::equals;
/*
이미 생성된 객체의 메서드를 람다식에 사용한 경우에는 클래스 이름 대신 그 객체의 참조변수를 적어줘야한다.
*/
```
> 생성자 메서드 참조
* 생성자를 호출하는 람다식도 메서드 참조가 가능하다.
```java
// 생성자 메서드 참조로 변경 전
Supplier<MyClass> s = () -> new MyClass();
// 생성자 메서드 참조로 변경 후
Supplier<MyClass> s = MyClass::new;
```
* 매개변수가 있는 생성자라면, 개수에 따라 알맞는 함수형 인터페이스를 사용한다.
```java
Function<Integer, MyClass> f = (i) -> new MyClass(i); // 람다식
Function<Integer, MyClass> f = MyClass::new; // 메서드 참조

BiFunction<Integer, String, MyClass> bf = (i, s) -> new MyClass(i, s); // 람다식
BiFunction<Integer, String, MyClass> bf = MyClass::new; // 메서드 참조
```
* 배열도 가능하다.
```java
Function<Integer, int[]> f = x -> new Int[x]; // 람다식
Function<Integer, int[]> f = int[]::new; // 메서드 참조
```

출처 : 남궁성. Java의 정석.도우출판:2016