package com.kwz.javatools.classloader;

import sun.net.spi.nameservice.dns.DNSNameService;

import java.io.File;

/**
 * Description
 * 演示了BootstrapClassLoader、ExtensionLoader、AppClassLoader三种内置的加载器
 * Date 2021/3/15 23:44
 * Created by kwz
 */
public class ClassLoaderDemo1 {

    public static void main(String[] args) {

        String url = "http://baidu.com.cn/124457";
        String[] split = url.split(File.separator);
        System.out.println(split);
    }

    /**
     * 根加载器是最底层的加载器，它主要负责加载由系统属性"sun.boot.class.path"指定路径下的核心类库，即
     * <JAVA_HOME>\jre\lib，处于安全考虑，根类加载器只加载java、javax、sun开头的类
     */
    private static void testBootstrapClassLoader() {
        ClassLoader bootstrapClassLoader = Object.class.getClassLoader();
        //打印出来的为null，这是因为它使用了根类加载器（Bootstrap）
        //bootstrapClassLoader:null
        System.out.println("bootstrapClassLoader:" + bootstrapClassLoader);
    }

    /**
     * sun.misc.Launcher$ExtClassLoader@46f5f779
     * 扩展类加载器负责加载<JAVA_HOME>\jre\lib\ext目录下的类库或者系统变量"java.ext.dirs"指定的目录下的类库
     */
    private static void testExtensionLoader() {
        ClassLoader extensionClassLoader = DNSNameService.class.getClassLoader();
        //extensionClassLoader:sun.misc.Launcher$ExtClassLoader@46f5f779
        System.out.println("extensionClassLoader:" + extensionClassLoader);
    }

    /**
     * 系统类加载器又称为应用类加载器(System classloader 或者Application classloader)
     */
    private static void testAppClassLoader() {
        ClassLoader appClassLoader = ClassLoaderDemo1.class.getClassLoader();
        //appClassLoader:sun.misc.Launcher$AppClassLoader@14dad5dc
        System.out.println("appClassLoader:" + appClassLoader);
    }

    /**
     * 双亲委派机制测试
     */
    private static void testParentalAppointment() {
        ClassLoader classLoader = ClassLoaderDemo1.class.getClassLoader();
        while (classLoader != null) {
            //one:sun.misc.Launcher$AppClassLoader@14dad5dc
            //one:sun.misc.Launcher$ExtClassLoader@27082746
            System.out.println("one:" + classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
