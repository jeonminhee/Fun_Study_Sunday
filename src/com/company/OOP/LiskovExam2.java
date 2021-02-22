package com.company.OOP;

/*
 * 첫번째 요구사항:
 * 1. 직사각형을 정의하고 직사각형의 둘레를 구할 수 있는 클래스를 만들기
 * 2. 직사각형의 둘레가 20이 아니라면 예외를 던지기
 *
 * 두번째 요구사항:
 * 1. 정사각형을 정의하고 둘레를 구할 수 있는 클래스를 만들기
 * */

// 사각형을 정의하고 사각형의 넓이를 구하는 클래스
class AbstractSquare1 {
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

class Rectangle4 extends  AbstractSquare1 {

}

class Square2 extends AbstractSquare1 {
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

public class LiskovExam2 {

    public static boolean isCheck(AbstractSquare1 square) {
        return square.getArea() == 20;
    }

    public static void main(String[] args) {
        AbstractSquare1 rectangle = new Rectangle4();
        rectangle.setHeight(5);
        rectangle.setWidth(4);

        if(!isCheck(rectangle)) {
            throw new RuntimeException();
        }

        // 정사각형의 상위 클래스가 직사각형이 아니기 때문에 리스코프 치환 원칙에 위반되지 않음
    }
}
