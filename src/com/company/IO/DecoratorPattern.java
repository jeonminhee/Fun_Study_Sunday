package com.company.IO;

abstract class Beverage {
    String name;

    public abstract int cost();

    public String getName() {
        return name;
    }
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getName();
}

class Americano extends Beverage {

    public Americano() {
//        super();
        name = "아메리카노";
    }

    @Override
    public int cost() {
        return 4000;
    }

}

class CaffeLatte extends Beverage {

    public CaffeLatte() {
        super();
        name = "카페라떼";
    }

    @Override
    public int cost() {
        return 5000;
    }

}

class Cream extends CondimentDecorator {

    Beverage beverage;

    public Cream(Beverage beverage) {
        super();
        this.beverage = beverage;
    }

    @Override
    public String getName() {
        return beverage.getName() + ", 크림";
    }

    @Override
    public int cost() {
        return beverage.cost() + 500;
    }
}

class Shot extends CondimentDecorator {

    Beverage beverage;

    public Shot(Beverage beverage) {
        super();
        this.beverage = beverage;
    }

    @Override
    public String getName() {
        return beverage.getName() + ", 샷";
    }

    @Override
    public int cost() {
        return beverage.cost() + 400;
    }



}

public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage b1 = new Americano();
        b1 = new Shot(b1); //beverage 필드에 Amerciano 인스턴스 저장
        b1 = new Shot(b1); //beverage 필드에 Shot 인스턴스 저장

        Beverage b2 = new Cream(new Cream(new CaffeLatte()));

        System.out.println("메뉴 : " + b1.getName());
        System.out.println("가격 : " + b1.cost());
        System.out.println("메뉴 : " + b2.getName());
        System.out.println("가격 : " + b2.cost());
    }
}
