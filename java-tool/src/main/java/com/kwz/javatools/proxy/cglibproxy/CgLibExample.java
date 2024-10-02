package com.kwz.javatools.proxy.cglibproxy;

import com.kwz.javatools.proxy.Bus;
import com.kwz.javatools.proxy.Vehicle;

/**
 * Description 创建CGLIB的代理类，利用CGLIB的方法进行调用
 * Date 2021/1/24 22:48
 * Created by kwz
 */
public class CgLibExample {

    public static void main(String[] args) {
        // 创建CGLIB 代理类
        CglibProxy cglibProxy = new CglibProxy();
        //初始化代理对象,执行方法
        Vehicle bus = (Vehicle) cglibProxy.getInstance(new Bus());
        bus.running();
    }
}
