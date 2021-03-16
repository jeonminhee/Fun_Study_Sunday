package com.company.Generics.ex1;

import java.util.ArrayList;

class Fruit                 { public String toString() { return "Fruit"; } }
class Apple extends Fruit   { public String toString() { return "Apple"; } }
class Grape extends Fruit   { public String toString() { return "Grape"; } }
class Toy                   { public String toString() { return "Toy";   } }

class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox   = new Box<Toy>();
        // Box<Grape> grapeBox = new Box<Apple>(); // 에러, 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // Ok. void add(Fruit item), Fruit의 자손들은 메서드의 매개변수가 될 수 있다.
        fruitBox.add(new Grape()); // Ok. void add(Fruit item), Fruit의 자손들은 메서드의 매개변수가 될 수 있다.

        appleBox.add(new Apple());
        // appleBox.add(new Toy()); // 에러, Box<Apple>에는 Apple만 담을 수 있음.

        toyBox.add(new Toy());
        // toyBox.add(new Apple()); // 에러, Box<Toy>에는 Toy만 담을 수 있음.

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    } // main
}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();

    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
