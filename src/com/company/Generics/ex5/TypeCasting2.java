package com.company.Generics.ex5;

public class TypeCasting2 {

    public static void main(String[] args) {
        Box<String> stringBox = null;
        Box<Object> objectBox = null;

        // objectBox = (Box<Object>) stringBox; // 에러, Box<String> -> Box<Object>
        // stringBox = (Box<String>) objectBox; // 에러, Box<Object> -> Box<String>
        // -> Box<Object> objectBox = new Box<String>();

        Box<? extends Object> wBox = new Box<String>();
        // 다형성, 형변환이 된다.
    }
}
