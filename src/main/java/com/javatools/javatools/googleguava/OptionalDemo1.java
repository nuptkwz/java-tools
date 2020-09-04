package com.javatools.javatools.googleguava;

import com.google.common.base.Optional;

/**
 * Description
 * Date 2020/9/3 23:48
 * Created by kwz
 */
public class OptionalDemo1 {
    public static void main(String args[]) {
        OptionalDemo1 optionalDemo1 = new OptionalDemo1();

        Integer value1 = null;
        Integer value2 = new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalDemo1.sum(a, b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(0);

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
