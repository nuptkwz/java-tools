package com.kwz.javatool.generic;

/**
 * Description
 * Date 2021/1/20 20:43
 * Created by kwz
 */
public class Parent<L, R> {
    private L foo1;
    private R foo2;

    public L getFoo1() {
        return foo1;
    }

    public void setFoo1(L foo1) {
        this.foo1 = foo1;
    }

    public R getFoo2() {
        return foo2;
    }

    public void setFoo2(R foo2) {
        this.foo2 = foo2;
    }
}
