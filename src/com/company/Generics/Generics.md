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
```
---
## 지네릭 클래스의 객체 생성과 사용
* FruitBoxEx1.java 파일 참조
---
## 제한된 지네릭 클래스
* FruitBoxEx2.java 파일 참조