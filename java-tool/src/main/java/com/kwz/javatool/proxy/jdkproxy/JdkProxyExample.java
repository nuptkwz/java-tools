package com.kwz.javatool.proxy.jdkproxy;


import com.kwz.javatool.proxy.JDKProxy;
import com.kwz.javatool.proxy.Taxi;
import com.kwz.javatool.proxy.Vehicle;

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
