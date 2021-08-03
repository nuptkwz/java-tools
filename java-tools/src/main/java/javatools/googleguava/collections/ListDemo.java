package javatools.googleguava.collections;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Date 2020/8/16 22:28
 * Created by kwz
 */
public class ListDemo {

    public static void main(String[] args) {
        testLists();
    }

    private static void testLists() {
        List<Integer> lists = Lists.newArrayListWithExpectedSize(2);
        lists.add(1);
        lists.add(2);
        lists.add(3);
        System.out.println(lists);
    }
}
