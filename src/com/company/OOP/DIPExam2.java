package com.company.OOP;

class Car2 {
    public String name;
    public absTire1 tire;
    public Car2(String name, absTire1 tire) {
        this.name = name;
        this.tire = tire;
    }
}

class absTire1 {
    public String name;
}

class SnowTire2 extends absTire1 {
    String name = "스노우타이어";
}

class Tire2 extends absTire1 {
    String name = "그냥 타이어";
}

public class DIPExam2 {
    Car2 c1 = new Car2("자동차1", new Tire2());
    Car2 c2 = new Car2("자동차2", new SnowTire2());

}
