package javatools.classloader;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.*;
import java.util.concurrent.ExecutionException;

/**
 * Description
 * 自定义类加载器：
 * 步骤：
 * 1.继承ClassLoader
 * 2.覆盖findClass方法
 * Date 2021/3/16 23:45
 * Created by kwz
 */
public class MyFileClassLoader extends ClassLoader {
    //被加载类所在的目录
    private String directory;

    //默认父加载器就是系统类加载器AppClassLoader
    public MyFileClassLoader(String directory) {
        this.directory = directory;
    }

    public MyFileClassLoader(String directory, ClassLoader parent) {
        super(parent);
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //1.把类名转换成目录

            String file = directory + File.separator + name.replace(".", File.separator)
                    + ".class";
            //构建输入流
            InputStream inputStream = new FileInputStream(file);
            //构建字节输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte buff[] = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buff)) != 1) {
                byteArrayOutputStream.write(buff, 0, len);
            }
            byte[] data = byteArrayOutputStream.toByteArray();
            inputStream.close();
            byteArrayOutputStream.close();
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        MyFileClassLoader classLoader = new MyFileClassLoader("D:/code/test/");
        Class<?> clazz = classLoader.loadClass("Demo2");
        clazz.newInstance();
    }
}
