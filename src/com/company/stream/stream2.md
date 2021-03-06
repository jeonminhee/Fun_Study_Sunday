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
* parallel()를 호출하면 된다.
* parallel() 호출을 취소하기 위해서는 sequential()을 사용한다.
```java
int sum = strStream.parallel() // strStream을 병렬 스트림으로 전환
                   .mapToInt(s -> s.length())
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
***
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
***
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
***
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
***
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
***
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
***
#### 요소가 없는, 비어있는 스트림을 생성하는 empty()
* 스트림에서 연산을 수행한 결과가 하나도 없을 때, null보다 빈 스트림을 반환하는 것을 권장한다.
```java
Stream emptyStream = Stream.empty();
long count = emptyStream.count(); // 0
```
***
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
***
## 스트림의 중간연산
> 스트림 자르기
#### 스트림의 일부를 잘라내는 skip(), limit()
* skip(n)은 처음 n개의 요소를 건너뛰고, limit(n)는 스트림의 요소를 n개로 제한한다.
```java
Stream<T> skip(long n)
Stream<T> limit(long maxSize)
```
```java
IntStream intStream = IntStream.rangeClosed(1, 10); // 1~10의 요소를 가진 스트림
intStream.skip(3).limit(5).forEach(System.out::println); // 45678 출력
```
***
> 스트림 요소 걸러내기
#### 중복 요소를 제거하는 distinct(), 조건(Predicate)에 맞지않는 요소를 걸러내는 filter()
```java
Stream<T> filter(Predicate<? super T> predicate)
String<T> distinct()
```
* distinct()의 사용방법
```java
IntStream intStream = IntStream.of(1,2,2,3,3,4,5,5,6);
intStream.distinct().forEach(System.out::println); // 123456
```
* filter()는 매개변수로 Predicate를 필요로하는데, 연산결과가 boolean인 람다식을 사용해도 된다.
```java
IntStream intStrean = IntStream.rangeClosed(1, 10); // 1~10
intStream.filter(i -> i % 2 == 0).forEach(System.out::println); // 2 4 6 8 10
```
* 필요하다면, filter()를 다른 조건으로 여러번 사용이 가능하다.
```java
// 아래의 두 문장은 동일한 결과를 얻는다.
intStream.filter(i -> i%2 != 0 && i%3 != 0).forEach(Systsem.out::println); //157
intStream.filter(i -> i%2 != 0).filter(i -> i%3 != 0).forEach(Systsem.out::println); //157
```
***
> 정렬
#### 스트림 요소를 정리하는 sorted()
```java
Stream<T> sorted()
Stream<R> sorted(Comparator<? super T> comparator)
```
* 지정된 Comparator로 스트림을 정렬한다.
    * Comparator 대신 int 값을 반환하는 람다식을 사용하는 것도 가능하다.
* Comparator를 지정하지 않으면 기본 정렬 기준(Comparable)으로 정렬한다.
```java
Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
strStream.sorted().forEach(System.out::println); // CC aaa b cc dd
/*
문자열 스트림, String에 정의된 기본정렬(사전순)으로 정렬해서 출력한다.
*/
```
* Stream03.java 파일 참조
* Stream04.java 파일 참조
***
> 변환
#### 원하는 필드만 뽑아내거나 특정형태로 변환시켜주는 map()
* 매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야한다.
```java
Stream<R> map(Function<? super T,? extends R> mapper)
```
```java
// File의 스트림에서 파일의 이름만 출력하는 예제
Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"),
                                    new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));

// map()으로 Stream<File>을 Stream<String>으로 변환
Stream<String> filenameStream = fileStream.map(File::getName);
filenameStream.forEach(System.out::println); // 스트림의 모든 파일이름을 출력
```
* map()도 filter()처럼 하나의 스트림에 여러번 적용 가능하다.
```java
// File의 스트림에서 파일의 확장자만을 뽑은 다음 중복을 제거해서 출력한다.
fileStream.map(File::getName) // Stream<File> -> Stream<String>
    .filter(s -> s.indexOf('.' != -1) // 확장자가 없는 것은 제외
    .peek(s -> System.out.printf("filename = %s%n", s)) // 파일명을 출력한다.
    .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
    .peek(s -> System.out.printf("extension = %s%n", s)) // 확장자를 출력한다.
    .forEach(System.out::println);
```
* Stream05.java 파일 참조
***
> mapToInt(), mapToLong(), mapToDouble()
#### Stream\<T> 타입의 스트림을 기본형 스트림으로 변환할때 사용한다.
* 스트림의 요소를 숫자로 변환하는 경우 IntStream과 같은 기본형 스트림으로 변환하는 것이 더 유용할 수 있다.
```java
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
IntStream    mapToInt(ToIntFunction<? super T> mapper)
LongStream   mapToLong(ToLongFunction<? super T> mapper)
```
* Stream04.java 파일 예제를 참고하자.
    * studentStream에서 스트림에 포함된 모든 학생의 성적을 합산해야 한다면, map()을 사용하면 된다.
```java
Stream<Integer> studentScoreStream = studentStream.map(Student::getTotalScore);
```
* 이럴때는 애초에 mapToInt()를 사용해서 IntStream타입 스트림을 생성하는게 더 효율적이다.
    * 연산을 할때, Integer를 int로 변환할 필요가 없기 때문이다.
```java
IntStream studentStream = studentStream.mapToInt(Student::getTotalScore);
int allTotalScore = studentStream.sum();
```
#### 기본형 스트림은 숫자를 다루는데 편리한 메서드들을 제공한다.
* Stream\<T>는 count()만 지원한다.

|스트림 유형|반환타입|메서드|설명|
|------|---|------|---|
|Stream\<T>|long|count()|스트림의 모든 요소의 총 개수|
|IntStream|int|sum()|스트림의 모든 요소의 총합|
|DoubleStream|OptionalDouble|average()|sum() / (double)count()|
|IntStream|OptionalInt|max()|스트림 요소 중 제일 큰 값|
|IntStream|OptionalInt|min()|스트림 요소 중 제일 작은 값|
* Optional을 반환하는 이유?
    * 스트림의 요소가 하나도 없을 때 sum()은 0을 반환하면 된다.
    * 다른 메서드(average...)들은 여러 요소들을 합한 평균이 0일 수도 있기 때문에 단순히 0을 반환할 수 없다.
    * 구분하기위해 OptionalDouble을 반환하는 것이다.
        * 요소가 없을 경우 empty를 반환한다.

* 위의 메서드들은 최종 연산이기 때문에 호출 후 스트림이 닫힌다는 점을 주의해야한다.
    * 하나의 스트림에서 sum()과 average()를 연속하여 호출 할 수 없다.
    * 모두 호출해야할때, 스트림을 또 생성하는 불편함이 있다.
        * summaryStatistics()라는 메서드를 사용하자.
```java
IntSummaryStatistics stat = scoreStream.summaryStatistics();
long totalCount = stat.getCount();
long totalScore = stat.getSum();
double avgScore = stat.getAverage();
int minScore    = stat.getMin();
int maxScore    = stat.getMax();
```           
#### 기본형 스트림을 Stream\<T>로 변환하는 메서드
* IntStream을 Stream\<T>로 변환 : mapToObj()
* IntStream을 Stream\<Integer>로 변환 : boxed()
```java
/* 로또 번호를 생성해서 출력하는 코드이다.
   mapToObj()를 이용해서 IntStream을 Stream<String>으로 변환하였다. */
IntStream intStream = new Random().ints(1,46); // 1-45사이의 정수(46은 포함되지 않음)
Stream<String> lottoStream = intStream.distinct().limit(6).sorted()
                                      .mapToObj(i -> i+","); // 정수를 문자열로 변환
lottoStream.forEach(System.out::println);
```
참고!
* Stream\<String>을 IntStream으로 변환 : mapToInt(Integer::parseInt);
* Stream\<Integer>을 IntStream으로 변환 : mapToInt(Integer::intValue);
***
> flatMap()
#### Stream\<T[]>를 Stream\<T>로 변환하는 메서드
* 스트림의 요소가 배열이거나 map()의 연산결과가 배열인 경우, 즉 스트림의 타입이 Stream\<T[]>인 경우 flatMap()을 사용하여 Stream<T>로 변환한다. 
```java
String[] lineArr = {
    "Belive or not It is true",
    "Do or do not There is no try"
};
Stream<String> lineStream = Arrays.stream(lineArr);
Stream<String> strStream = lineStream
                           .flatMap(line->Stream.of(line.split(" +")));
```
* Stream06.java 파일 참조
***
## 스트림의 최종연산
> forEach()
#### peek()와 달리 스트림의 요소를 소모하는 최종연산
```java
void forEach(Cunsumer<? super T> action)
// 반환타입이 void 이므로 스트림의 요소를 출력하는 용도로 많이 사용된다.
```
> 조건검사 - allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
#### 요소에 대해 지정된 조건에 모든 요소가 일치하는지, 
#### 일부만 일치하는지 혹은 어떤 요소도 일치하지 않는지 확인하는데 사용되는 메서드
* 매개변수로 Predicate를 요구하며 연산결과로 boolean을 반환한다.
```java
boolean allMatch (Predicate<? super T> predicate)
boolean anyMatch (Predicate<? super T> predicate)
boolean noneMatch(Predicate<? super T> predicate)
```
* 학생 성적 정보 스트림 (stuStream)에서 총점이 낙제점(총점 100이하)인 학생이 있는지 확인하는 방법
```java
boolean noFailed = stuStream.anyMatch(s -> s.getTotalScore() <= 100)
/* Predicate 함수형 인터페이스
   매개값을 조사하여 true 혹은 false를 리턴한다. */
```
* 조건에 일치하는 첫번째 것을 반환하는 findFirst()
    * 주로 filter()와 함께 사용한다.
    * 병렬스트림인 경우에는 findAny()를 사용한다.

```java
Optional<Student> stu = stuStream.filter(s -> s.getTotalScore() <= 100).findFirst();
Optional<Student> stu = parallelStream.filter(s -> s.getTotalScore() <= 100).findAny();
/* findAny와 findFirst의 반환 타입은 Optional<T> */
```
> 통계 - count(), sum(), average(), max(), min()
#### 기본형 스트림(IntStream)이 아닌 경우에는 통계와 관련된 메서드들이 3개뿐이다.
```java
long        count()
Optional<T> max(Comparator<? super T> comparator)
Optional<T> min(Comparator<? super T> comparator)
/* 기본형 스트림의 min(), max()와 달리 매개변수로 Comparator를 필요로 한다. */
```
* 대부분의 경우 위의 메서드를 사용하기보다 기본형 스트림으로 변환하거나 reduce()와 collect()를 사용해서 통계 정보를 얻는다.
> 리듀싱 - reduce()
#### 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과를 반환한다.
* 초기값이 없는 reduce()
    * reduce()의 param으로 (total, n) -> total + n가 전달되고
reduce는 a, b, c...의 stream을 a + b + c...로 연산을 수행한다. 첫번째로 total=a, n=ab가 되고, 두번째로 total=(a+b), n=c가 되는 형식이다.
* Stream07.java 파일 참조
--- 
* 초기값이 있는 reduce()
    * 동일하게 동작하지만 초기값을 지정할 수 있다.
    * 첫번째 param으로 초기값을 넘겨주면 된다.
* Stream08.java 파일 참조
---
* 병렬처리 + reduce()
    * parallel()을 사용하면 병렬처리 연산이 가능해진다.
    * 순차적으로 수행하지않고 여러개의 작업을 병렬로 처리한다.
    * (a+b) + (c+d) + (e+f) + ... 
* Stream09.java 파일 참조

