package com.javatools.javatools.proxy.jdkproxy;

import com.javatools.javatools.proxy.Taxi;
import com.javatools.javatools.proxy.Vehicle;

/**
 * Description
 * JDK动态代理的例子
 * Date 2021/1/24 1:05
 * Created by kwz
 */
public class JdkProxyExample {

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Vehicle taxiInstance = (Vehicle) jdkProxy.getInstance(new Taxi());
        taxiInstance.running();
    }
}
