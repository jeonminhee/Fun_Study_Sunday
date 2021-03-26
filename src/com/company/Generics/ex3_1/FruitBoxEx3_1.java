package com.company.Generics.ex3_1;

import java.util.ArrayList;

class Fruit               { public String toString() { return "Fruit"; } }
class Apple extends Fruit { public String toString() { return "Apple"; } }
class Grape extends Fruit { public String toString() { return "Grape"; } }

class Juice {
    String name;
    Juice(String name) { this.name = name + "Juice"; }
    public String toString() { return name; }
}

class Juicer {
    static Juice makeJuice(FruitBox<Fruit> box) { // <Fruit>로 지정
        String tmp = "";
        for(Fruit f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }

//    static Juice makeJuice(FruitBox<Apple> box) { // <Apple>로 지정
//        String tmp = "";
//        for(Fruit f : box.getList()) {
//            tmp += f + " ";
//        }
//        return new Juice(tmp);
//    }
    /**
     * 오버로딩 시 컴파일 에러 발생!
     * 지네릭 타입이 다른것만으로는 오버로딩이 성립하지 않는다.
     * 지네릭 타입은 컴파일러가 컴파일 할 때만 사용하고 제거해버린다.
     * 위의 두 메서드는 오버로딩이 아니라 '메서드 중복 정의'이다.
     * 이런 경우를 위해 '와일드 카드'를 사용한다.
     */
}

class FruitBoxEx3_1 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        // System.out.println(Juicer.makeJuice(appleBox));
    } // main
}

class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}