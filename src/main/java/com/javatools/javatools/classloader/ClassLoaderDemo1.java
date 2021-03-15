package com.javatools.javatools.classloader;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * Description
 * Date 2021/3/15 23:44
 * Created by kwz
 */
public class ClassLoaderDemo1 {

    public static void main(String[] args) {
        testExtensionLoader();
    }

    /**
     * 根加载器是最底层的加载器，它主要负责加载由系统属性"sun.boot.class.path"指定路径下的核心类库，即
     * <JAVA_HOME>\jre\lib，处于安全考虑，根类加载器只加载java、javax、sun开头的类
     */
    private static void testBootstrapClassLoader() {
        ClassLoader classLoader = Object.class.getClassLoader();
        //打印出来的为null，这是因为它使用了根类加载器（Bootstrap）
        System.out.println(classLoader);
    }

    /**
     * sun.misc.Launcher$ExtClassLoader@46f5f779
     * 扩展类加载器负责加载<JAVA_HOME>\jre\lib\ext目录下的类库或者系统变量"java.ext.dirs"指定的目录下的类库
     */
    private static void testExtensionLoader() {
        ClassLoader classLoader = DNSNameService.class.getClassLoader();
        System.out.println(classLoader);
    }

    /**
     * 系统类加载器又称为应用类加载器(System classloader 或者Application classloader)
     *
     */
    private static void testAppClassLoader() {

    }
}
