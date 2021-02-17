package com.company.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest3 implements Runnable {
    private Vector<Integer> v;

    public VectorTest3(Vector<Integer> v) {
        this.v = v;
    }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                v.add(i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
        }
    }


    public static void main(String[] args) throws Exception {
        Vector<Integer> v = new Vector<Integer>();

        Thread t1 = new Thread(new VectorTest3(v));
        Thread t2 = new Thread(new VectorTest3(v));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(v.size());
        for (int i = 0; i < v.size(); i++) {
            System.out.println(i + "  " + v.get(i));
        }

    }
}
