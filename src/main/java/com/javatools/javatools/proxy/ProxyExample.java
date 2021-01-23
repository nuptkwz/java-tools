package com.javatools.javatools.proxy;

/**
 * Description
 * JDK动态代理的例子
 * Date 2021/1/24 1:05
 * Created by kwz
 */
public class ProxyExample {

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Vehicle taxiInstance = (Vehicle) jdkProxy.getInstance(new Taxi());
        taxiInstance.running();
    }
}
