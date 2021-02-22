package com.company.OOP;

class Car1 {
    public String name;
    public Tire1 tire;
    public Car1(String name, Tire1 tire) {
        this.name = name;
        this.tire = tire;
    }
}

class SnowTire1 {
    String name = "스노우타이어";
}

class Tire1 {
    String name = "그냥 타이어";
}

public class DIPExam1 {
    Car1 c1 = new Car1("자동차1", new Tire1());
//    Car1 c2 = new Car1("자동차2", new SnowTire1()); //오류 발생

}
