package javatools.java8;

import java.util.stream.Stream;

/**
 * Description
 * Date 2020/9/2 23:32
 * Created by kwz
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::print);
    }
}
