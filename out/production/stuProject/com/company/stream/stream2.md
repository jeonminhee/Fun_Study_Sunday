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
#### Collection(컬렉션의 최고 조상)에는 stream()이 정의되어 있다.
* 자손인 List, Set을 구현한 컬렉션 클래스들은 모두 stream() 메서드를 통해 스트림을 생성할 수 있다.
```java
Stream<T> Collection.stream();
```
List로부터 스트림을 생성하는 코드는 다음과 같다.
```java
List<Integer> list = Arrays.asList(1,2,3,4,5); // 가변인자
Stream<Integer> intStream = list.stream(); //  list를 소스로 하는 컬렉션 생성
```
> 배열
#### 배열을 소스로 스트림을 생성하는 메서드는 Stream과 Arrays에 static 메서드로 정의되어있다.

```java
/* 문자열 스트림 생성 방법 */
Stream<T> Stream.of(T... values) // 가변인자
Stream<T> Stream.of(T[])
Stream<T> Arrays.stream(T[])
Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
```
```java
/* 기본형(int, long, double) 배열 스트림 생성 방법  */
IntStream IntStream.of(int... vlalue) // IntStream으로 반환한다.
IntStream IntStream.of(int[])
IntStream Arrays.stream(Int[])
IntStream Arrays.stream(Int[] array, int startInclusive, int endExclusive)
/* long과 double 타입도 위와 같다. */
```
> 특정 범위의 정수
#### 지정된 범위의 연속된 정수를 반환하는 IntStream, LongStream의 메서드
* range()와 rangeClosed()
```java
IntStream       InStream.range(int begin, int end);
IntStream       InStream.rangeClosed(int begin, int end);
// range()의 경우 end가 범위에 포함되지 않고, rangeClosed()는 포함된다.
IntStream       InStream.range(1, 5); // 1,2,3,4
IntStream       InStream.rangeClosed(1, 5); // 1,2,3,4,5
```
> 임의의 수
#### 지정 타입의 난수들로 이루어진 스트림을 반환하는 Random클래스의 메서드들
```java
IntStream     ints()
LongStream    longs()
DoubleStream  doubles()
```
* 위의 메서드들이 반환하는 스트림은 크기가 정해지지 않은 '무한 스트림'이다.
    * limit() 메서드를 사용하여 스트림의 크기를 제한해주어야한다.
```java
IntStream       intStream = new Random.ints(); // 무한스트림
IntStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력한다.
```
* 아래의 메서드들은 매개변수로 스트림의 크기를 지정한다.
    * limit() 메서드를 사용하지 않아도 된다.
```java
IntStream     ints(long streamSize)
LongStream    longs(long streamSize)
DoubleStream  doubles(long streamSize)

IntStream intStream = new Random.ints(5); // 크기가 5인 난수 스트림을 반환
```
* 지정된 범위의 난수를 발생시키는 스트림 메서드는 다음과 같다.
    * end는 범위에 포함되지 않는다.
```java
IntStream     ints(int begin, int end)
LongStream    longs(int begin, int end)
DoubleStream  doubles(int begin, int end)

IntStream     ints(long streamSize, int begin, int end)
LongStream    longs(long streamSize, int begin, int end)
DoubleStream  doubles(long streamSize, int begin, int end)
```
* Stream02.java 파일 참조
> 람다식
#### 람다식을 매개변수로 받는 Stream 클래스의 iterate(), generate()
* 무한 스트림을 생성한다.
```java
static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
static <T> Stream<T> generate(Supplier<T> s)
/*
Supplier<T> 함수형 인터페이스
: JDK1.8에서 기본으로 제공하는 함수형 인터페이스
: 인자는 받지않으며, 반환값만 존재한다.
Supplier<String> name = () -> "minhee";  
String result = name.get();
System.out.println(result); // minhee 출력
*/
/*
UnaryOperator<T> 함수형 인터페이스
: Function<T,R> 에서 확장한 람다식
: <T>형태의 입력값을 받아 <T>형태의 출력값을 리턴한다.
UnaryOperator<String> uo = x -> x.toUpperCase();
System.out.println("UnaryOperator test ="+ uo.apply("hello")); -> HELLO 출력
*/
```
* ierate() : seed로 지정된 값부터 시작해서 람다식 f에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.
```java
Stream<Integer> evenStream = Stream.iterator(0, n->n+2); // 0, 2, 4, 6 ... 
```
| n -> n + 2 |
|:------|---:|
| 0 -> 0 + 2 |
| 2 -> 2 + 2 |
| 4 -> 4 + 2 |

* generate() : iterate()처럼 람다식에 의해 계산되는 값을 요소로 하는 무한스트림을 생성하지만, 이전 결과를 이용하지 않는다.
```java
Stream<Double> randomStream = Stream.generate(Math::random);
Stream<Integer> oneStream   = Stream.generate(() -> 1);
```
generate()에 정의된 매개변수의 타입은 Supplier이므로 매개변수가 없는 람다식만 허용된다.

주의! iterate()와 generate()로 생성된 스트림은 기본형 스트림 타입의 참조변수로 다룰 수 없다.
```java
IntStream evenStream = Stream.iterator(0, n->n+2); // 에러
DoubleStream randomStream = Stream.generate(Math::random); // 에러
``` 
> 파일
#### 지정된 디렉토리에 있는 파일의 목록을 스트림으로 반환하는 list()
```java
// Path는 하나의 파일 또는 경로를 의미한다.
Stream<Path> Files.list(Path dir)
```
#### 파일의 한 행을 요소로 하는 스트림을 생성하는 메서드 lines()
```java
Stream<String> Files.lines(Path path)
Stream<String> Files.lines(Path path, Charset cs)
Stream<String> lines() // BufferedReader 클래스의 메서드
```
> 빈 스트림
#### 요소가 없는, 비어있는 스트림을 생성하는 empty()
* 스트림에서 연산을 수행한 결과가 하나도 없을 때, null보다 빈 스트림을 반환하는 것을 권장한다.
```java
Stream emptyStream = Stream.empty();
long count = emptyStream.count(); // 0
```
> 두 스트림의 연결
#### 두 스트림을 하나로 연결하는 concat()
* 연결하려는 두 스트림의 요소는 같은 타입이여야한다.
```java
String[] str1 = {"123", "456"};
String[] str2 = {"abc", "def"};

Stream<String> strs1 = Stream.of(str1);
Stream<String> strs2 = Stream.of(str2);
Stream<String> strs3 = Stream.concat(strs1, strs2); // 두 스트림을 하나로 연결
```