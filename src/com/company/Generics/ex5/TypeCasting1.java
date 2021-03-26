package com.company.Generics.ex5;

public class TypeCasting1 {

    public static void main(String[] args) {
        Box         box = null;
        Box<Object> objectBox = null;

        box = (Box)objectBox;
        objectBox = (Box<Object>)box;
    }
}
