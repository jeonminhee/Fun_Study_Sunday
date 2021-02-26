package com.company.OOP;

 class Circle1 {

    public double radious;

    public Circle1(int radious) {
        this.radious = radious;
    }

}

class Rectangle1 {

    public double width;
    public double length;

    public Rectangle1 (int width, int length) {
        this.width = width;
        this.length = length;
    }

}

public class OCPExam1 {

    public double calculationCircle(Circle1 circle){

        return circle.radious * circle.radious * 3.14;

    }

    public double calculationRectangle(Rectangle1 rectangle){

        return rectangle.width * rectangle.length;

    }
}

// OCP 위반! 직사각형 클래스가 추가되면 기존의 Exam 클래스의 코드 변경됨