package com.javatools.javatools.generic;

import lombok.Data;

/**
 * Description
 * Date 2021/1/20 20:17
 * Created by kwz
 */
@Data
public class Fruit<T> {
    private T t;

    public static void main(String[] args) {
        Fruit<Apple> appleFruit = new Fruit<>();
        Fruit<Banana> bananaFruit = new Fruit<>();

        String hello = getT("hello");
        System.out.println(hello);
    }

    private static <T> T getT(T t){
        return t;
    }
}

@Data
class Apple {
    private int weight;
    private String color;
}

@Data
class Banana{
    private int weight;
    private String color;
}
