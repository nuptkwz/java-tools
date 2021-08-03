package javatools.proxy;

/**
 * Description
 * Date 2021/1/24 1:09
 * Created by kwz
 */
public class Taxi implements Vehicle {
    @Override
    public void running() {
        System.out.println("taxi is running...");
    }
}
