package com.company.OOP;

interface Figure {

    double calculator();

}

class Circle2 implements Figure{

    public double radius;

    @Override
    public double calculator() {
        return radius * radius * 3.14;
    }
}

class Rectangle2 implements Figure{

    public double width;
    public double length;

    
    @Override
    public double calculator() {
        return width * length;
    }
}

class Calculation {

    public double CalculatorFigure(Figure figure) {
        return figure.calculator();
    }

}

public class OCPExam2 {
    public static void main(String[] args){

        Calculation calculation = new Calculation();
        calculation.CalculatorFigure(new Circle2());

    }
}

// OCP를 위반하지 않았으므로 다른 도형을 추가하더라도 새로운 도형 클래스만 추가해주면