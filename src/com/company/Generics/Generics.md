# 지네릭스(Generics)
## 지네릭스란?
> 지네릭스의 정의
#### JDK 1.5에 도입된 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능
* 객체의 타입을 컴파일 시에 체크한다.
    * 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어듬
    * 타입 안정성?
        * 의도하지 않은 타입의 객체가 저장되는 것을 막는다.
        * 저장된 객체를 꺼내올 때 원래의 타입과 다른 타입으로 잘못 형변환되어 발생할 수 있는 오류를 줄여준다.
> 지네릭스의 장점
1. 타입 안정성을 제공
2. 타입 체크와 형변환을 생략할 수 있으므로 코드가 간결
---
## 지네릭 클래스의 선언
> 클래스에 선언
```java
class Box {
    Object item;

    void setItem(Object item) { this.item = item; }
    Object getItem() { return item; } 
}
```
```java
class Box<T> { // 지네릭 타입 T 선언
    T item;

    void setItem(T item) { this.item = item; }
    T getItem() { return item; }
}
```
* Box\<T>에서 T를 ***타입변수(type variable)*** 이라 한다. 
* ArrayList\<E>의 타입변수 E는 Element(요소)을 의미한다.
* Map\<K,V>의 타입변수 K,V는 Key(키), Value(값)을 의미한다.
* Generics01.java 파일 참조

> 지네릭스의 용어
```java
class Box<T> {}
```
```text
Box<T> : 지네릭 클래스. 'T의 Box'또는 'T Box'라고 읽는다.
T      : 타입 변수 또는 타입 매개변수. (T는 타입 문자)
Box    : 원시 타입(raw type)  
```
> 지네릭스의 제한
* static 멤버에 타입 변수 T를 사용할 수 없다.
    * static 멤버는 모든 객체에 대해 동일하게 동작해야한다.
    * T는 인스턴스 변수로 간주
    * static 멤버는 대입된 타입의 종류와 관계없이 동일한 것이여야 하기 때문이다.
```java
Box<Apple>.item
Box<Grape>.item
// 멤버가 static 일때는 다른것이어서는 안된다.
```
* 지네릭 타입의 배열을 생성할 수 없다.
    * 지네릭 배열 타입의 참조변수 선언은 가능
    * 'new T[10]'과 같이 배열을 생성하는 것은 불가능
    * 컴파일 시점에서 T가 뭔지 정확하게 알아야하기 때문이다.
```java
class Box<T> {
    T[] itemArr; // Ok. T타입의 배열을 위한 참조변수
    T[] toArray() {
        T[] tempArr = new T[itemArr.length]; // 에러, 지네릭 배열 생성불가
        return tempArr;
    }
}
// 배열의 경우 Object가 String의 부모이므로 Object[]도 String[]의 부모이다. 하지만 제너릭에선 ArrayList<Object>와 ArrayList<String>은 아예 다른 객체이다. 그래서 전자를 가리키는 레퍼런스 변수가 후자의 객체를 참조하지 못한다.
```
---
## 지네릭 클래스의 객체 생성과 사용
* FruitBoxEx1.java 파일 참조
---
## 제한된 지네릭 클래스
* FruitBoxEx2.java 파일 참조
---
## 와일드 카드
* FruitBoxEx3_0.java 파일 참조
* FruitBoxEx3_1.java 파일 참조

> 와일드 카드란?
```java
<? extends T>  와일드 카드의 상한 제한. T와 그 자손들만 가능
<? super T>    와일드 카드의 하한 제한. T와 그 조상들만 가능
<?>            제한 없음. 모든 타입이 가능하다. <? extends Object>와 동일
```
> extends로 와일드 카드의 상한을 제한하는 경우
* FruitBoxEx3_2.java 파일 참조
* FruitBoxEx3.java 파일 참조

> super로 와일드 카드의 하한을 제한하는 경우
* FruitBoxEx4.java 파일 참조
--- 
## 지네릭 메서드
> 메서드의 선언부에 지네릭 타입이 선언된 메서드
```java
static <T> void sort(List<T> list, Comparator<? super T> c)
```
* 지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드의 정의된 타입 매개변수는 별개의 것
    * 같은문자 T를 사용해도 같은 것이 아니라는 것에 주의!
```java
class FruitBox<T> {
    ...
    static <T> void sort(List<T> list, Comparator<? super T> c) {
        ...
    }
}
```
* static을 사용할 수 있는 이유?
    * 메서드 내에서만 지역적으로 사용될 것이므로 메서드가 static이건 아니건 상관이 없다!
```java
static Juice makeJuice(FruitBox<? extends Fruit> box) {
    String tmp = "";
    for(Fruit f : box.getList()) tmp += f + " ";
    return new Juice(tmp);
}
```
위의 makeJuice() 메서드를 지네릭 메서드로 변경하면?
```java
static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
    String tmp = "";
    for(Fruit f : box.getList()) tmp += f + " ";
    return new Juice(tmp);
}
```
이 메서드를 호출할때는 아래와 같이 타입 변수에 타입을 대입해야한다.
```java
FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
FruitBox<Apple> appleBox = new FruitBox<Apple>();
. . .
System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
System.out.println(Juicer.<Apple>makeJuice(appleBox));
```
그러나 대부분의 경우, 컴파일러가 타입을 추정할 수 있기 때문에 생략해도 된다.
fruitBox, appleBox의 선언부를 통해 대입된 타입을 컴파일러가 추정할 수 있다.
```java
System.out.println(Juicer.makeJuice(fruitBox));
System.out.println(Juicer.makeJuice(appleBox));
```
---
## 지네릭 타입의 형변환
* TypeCasting1.java 파일 참조
* TypeCasting2.java 파일 참조
---
## 지네릭 타입의 제거
> 지네릭 타입의 제거 과정
1. 지네릭 타입의 경계(bound)를 제거한다.
    - \<T extends Fruit> 라면, <T>는 Fruit로 치환된다.
    - \<T>인 경우는 Object로 치환된다.
```java
class Box<T extends Fruit> {
    void add (T t) {
        ...
    }
}
```
```java
class Box {
    void add(Fruit t) {
        ...
    }
}
```

2. 지네릭 타입을 제거한 후에 타입이 일치하지 않으면 형변환을 추가한다.
    - List의 get()은 Object 타입을 반환하므로 형변환이 필요하다.
```java
T get(int i) {
    return list.get(i);
}
```
```java
Fruit get(int i) {
    return (Fruit)list.get(i);
}
```