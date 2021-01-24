package com.company.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

    public static void main(String[] args) {
        int result = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println(result);

        result = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println(result);

        Supplier<String> name = () -> "minhee";
        String result2 = name.get();
        System.out.println(result2);

    }

}
