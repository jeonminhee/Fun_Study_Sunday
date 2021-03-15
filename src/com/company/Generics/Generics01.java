package com.company.Generics;

public class Generics01 {
    public static void main(String[] args) {
        Box01<String> b1 = new Box01<String>();

        // b.setItem(new Object()); // 에러, String 이외의 타입은 지정 불가
        b1.setItem("ABC"); // Ok, String 타입이므로 가능

        String item_1 = (String) b1.getItem();
        String item_2 = b1.getItem(); // 형변환이 필요없다.

        Box01 b2 = new Box01(); // OK, T는 Object로 간주된다.
        b2.setItem("ABC"); // 경고 발생
        b2.setItem(new Object()); // 경고 발생

        /*
        * 지네릭스가 도입되기 전의 코드와 호환성을 유지하기 위해 지네릭스를 사용하지 않은 코드를 허용하는 것일 뿐,
        * 지네릭 클래스를 사용할때는 반드시 타입을 지정하여 지네릭스와 관련된 경고가 나오지 않도록 해야한다.
        * */
    }
}
