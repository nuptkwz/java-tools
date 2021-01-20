package com.javatools.javatools.generic;

import lombok.Data;

/**
 * Description
 * 泛型中的通配符分为<?>、<? extends T>、<? super T>。其中
 * <?> 代表无界通配符
 * <? extends T> 代表上界通配符，表示T以及T的子类，即T是“最大的”
 * <? super T> 代表下界通配符，表示T以及T的父类，T是“最小的”。
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
