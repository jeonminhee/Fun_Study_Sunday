package com.company.OOP;

/*
* 첫번째 요구사항:
* 1. 직사각형을 정의하고 직사각형의 둘레를 구할 수 있는 클래스를 만들기
* 2. 직사각형의 둘레가 20이 아니라면 예외를 던지기
*
* 두번째 요구사항:
* 1. 정사각형을 정의하고 둘레를 구할 수 있는 클래스를 만들기
* */

// 직사각형을 정의하고 직사각형의 넓이를 구하는 클래스
class Rectangle3 {
    protected double width;
    protected double height;

    public void setWidth(double width) {
        this.width = width;
    }
    public double getWidth() {
        return this.width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return this.height;
    }
    public double getArea() {
        return this.getWidth() * this.getHeight();
    }
}

//직사각형을 상속받아 정사각형을 만듦
class Square1 extends Rectangle3 {
    @Override
    public void setWidth(double width) {
        this.width = width;
        this.height = width;
    }
    @Override
    public void setHeight(double height) {
        this.height = height;
        this.width = height;
    }
}

public class LiskovExam1 {

    public static boolean isCheck(Rectangle3 rectangle) {
        return rectangle.getArea() == 20;
    }

    public static void main(String[] args) {
//        Rectangle3 rectangle = new Square1();
        Rectangle3 rectangle = new Rectangle3();
        rectangle.setHeight(5);
        rectangle.setWidth(4);

        if(!isCheck(rectangle)) {
            throw new RuntimeException();
        }

        // 같은 코드를 실행시켰을 때, 직사각형의 경우 예외를 던지지 않지만, 정사각형으로 치환한 경우에는 예외를 던짐
    }
}
