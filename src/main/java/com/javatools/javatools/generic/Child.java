package com.javatools.javatools.generic;

/**
 * Description
 * Date 2021/1/20 20:46
 * Created by kwz
 */
public class Child<L, M, R> extends Parent<L, R> {
    private M foo3;

    public M getFoo3() {
        return foo3;
    }

    public void setFoo3(M foo3) {
        this.foo3 = foo3;
    }
}
