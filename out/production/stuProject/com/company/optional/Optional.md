# Optional<T>와 OptionalInt

> Optional<T> 클래스
- 지네릭 클래스
- 'T타입의 객체'를 감싸는 래퍼 클래스
- 모든 타입의 참조변수를 담을 수 있다.
- java.util.Optional, JDK1.8부터 새로 추가되었다.

```java
public final class Optional<T>{
	private final T value; // T타입의 참조변수
	...
}
```
! 최종 연산의 결과를 Optional 객체에 담아서 반환한다.
: : 반환된 결과가 null인지 매번 if문으로 체크하는 대신 Optional에 정의된 메서드를 통해서 간단하게 처리 가능
: : if문 없이도 NullPointerException이 발생하지 않는 '보다 간결하고 안전한 코드'를 작성 가능

***
> Optional 객체 생성하기, of() ofNllable
- Optional 객체를 생성할 때는 of() 또는 ofNullable을 사용한다.
```java
String name = "minhee";
Optional<String> optValue = Optional.of(name);
Optional<String> optValue = Optional.of("minhee");
Optional<String> optValue = Optional.of(new String("minhee"));
```
! 참조변수의 값이 null일 가능성이 있다면 of()대신 ofNullable()을 사용해야한다.
: : of()는 매개변수의 값이 null이면 NullPointerException을 발생시킨다.
```java
Optional<String> name = Optional.of(null); // NullPointerException 발생
Optional<String> name = Optional.ofNullable(null); // OK
```
tip) Optional<T>타입의 참조변수를 기본값으로 초기화할때는 empty()를 사용하는 것이 바람직하다.
***
> Optional 객체의 값 가져오기, get()
* Optional 객체의 저장된 값을 가져올 때는 get()을 사용한다.
  - null인 경우 : NoSuchElementException 발생
  - **orElse()**로 대체 값을 지정
```java
Optional<String> name = Optional.of("minhee");
String name1 = name.get(); // null이면 예외 발생
String name2 = name.orElse("null 입니다.") // null이면 "null 입니다"를 반환
```
> orElse()의 변형, ofElseGet() / ofElseThrow()
* ofElseGet() : null을 대체할 값을 반환하는 람다식을 지정할 수 있다.
* ofElseThrow() : null일 때 지정된 예외를 발생시킨다.
```java
T ofElseGet(Supplier<? extends T> other)
T ofElseThrow(Supplier<? extends X> exceptionSupplier)

/*
Supplier<T> 함수형 인터페이스
: JDK1.8에서 기본으로 제공하는 함수형 인터페이스
: 인자는 받지않으며, 반환값만 존재한다.
Supplier<String> name = () -> "minhee";  
String result = s.get();
System.out.println(result); // minhee 출력
*/
```
>> 사용하는 방법
```java
String name3 = name.orElseGet(String::new); // () -> new String()과 동일, 메서드 참조
String name4 = name.orElseThrow(NullPointException::new); // Null이면 예외발생
```
> filter(), map(), flatMap()의 사용
* Optional객체에서도 filter(), map(), flatMap()을 사용할 수 있다.
* 스트림 내용 추가하기... 