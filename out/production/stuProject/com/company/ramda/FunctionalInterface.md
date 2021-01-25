# 함수형 인터페이스 (Functional Interface)

>  함수형 인터페이스란?
- 람다식을 다루기 위한 인터페이스

#### 규칙
1. 메서드와 람다식이 1:1로 연결되기 위해 오직 하나의 추상 메서드만 정의되어 있어야한다.
2. static 메서드와 default 메서드의 개수에는 제약이 없다.
3. '@FunctionalInterface'를 붙이면 컴파일러가 올바르게 정의하였는지 확인해준다.

```java
@FunctioanlInterface
interface MyFunction { // 함수형 인터페이스 MyFunction을 정의
	public abstract int max(int a, int b);
}
```
- 기존에 불편함이 있었던 인터페이스 메서드 구현 방식
```java
List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
Collections.sort(list, new Comparator<String>() {
	public int compare(String s1, String s2){
		return s2.compareTo(s1);
	}
})

/* 
Interface Comparator<T>()
- 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스)들의 기본 정렬 기준과 다르게 정렬 하고 싶을 때 사용하는 인터페이스
- 주로 익명클래스로 사용된다.
- 기본 정렬방법인 오름차순 정렬을 내림차순으로 정렬할때 사용된다.
- 사용 방법
Arrays.sort(array, myComparator)
Collections.sort(list, myComparator)
Arrays.sort(), Collections.sort() 메서드는 두 번째 인자로 Comparator interface를 받을 수 있다.
*/
```
- 람다를 이용한 메서드 구현 방식
```java
List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
```

출처 : 남궁성. Java의 정석.도우출판:2016