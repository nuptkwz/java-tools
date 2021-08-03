package javatools.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description
 * Date 2021/1/24 1:10
 * Created by kwz
 */
public class JDKProxy implements InvocationHandler {
    //代理对象
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 执行代理方法
     *
     * @param proxy  代理对象
     * @param method 代理方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理之前的业务处理：");
        return method.invoke(target, args);
    }
}
