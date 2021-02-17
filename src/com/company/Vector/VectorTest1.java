package com.company.Vector;

import java.util.*;

public class VectorTest1 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(null);
        v.add(1, 100);

        for(Integer i : v) {
            System.out.println(i);
        }
        System.out.println("---------------");

        v.remove(1);

        for(Integer i : v) {
            System.out.println(i);
        }
        System.out.println("---------------");

        v.clear();
//        v.removeAllElements();

        for(Integer i : v) {
            System.out.println(i);
        }


    }
}
