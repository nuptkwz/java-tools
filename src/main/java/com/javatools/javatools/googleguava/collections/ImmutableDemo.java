package com.javatools.javatools.googleguava.collections;

import com.google.common.base.Joiner;
import com.google.common.collect.*;

/**
 * Description Immutable类特点
 * a.在多线程操作下，是线程安全的
 * b.所有不可变集合会比可变集合更有效的利用资源
 * c.中途不可改变
 * Date 2020/8/16 21:50
 * Created by kwz
 */
public class ImmutableDemo {

    public static void main(String[] args) {
//        testImmutable();
//        testGuavaMap();
//        testGuavaJoiner();
    }


    /**
     * 字符串连接器Joiner
     * Description
     * Param []
     * return void
     */
    private static void testGuavaJoiner() {
        StringBuilder stringBuilder = new StringBuilder("hello,");
        Joiner joiner = Joiner.on("|").skipNulls();
        StringBuilder newStringBuffer = joiner.appendTo(stringBuilder, "hello", "my", "name is", null, "Mike");
        System.out.println(newStringBuffer);
    }

    /**
     * Description
     * Param []
     * return void
     */
    private static void testImmutable() {
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");
        ImmutableSortedMap<String, String> iSortedMap = ImmutableSortedMap.of("c", "cValue", "f", "fValue", "a", "aValue");
        System.out.println("iList: " + iList.toString());
        System.out.println("iSet: " + iSet.toString());
        System.out.println("iMap: " + iMap.toString());
        System.out.println("iSortedMap" + iSortedMap.toString());
    }

    /**
     * Description
     * Param []
     * return void
     */
    private static void testGuavaMap() {
        //ArrayListMultimap
        Multimap<String, Integer> arrayListMultimap = ArrayListMultimap.create();
        arrayListMultimap.put("test", 1);
        arrayListMultimap.put("test", 3);
        arrayListMultimap.put("test", 2);
        arrayListMultimap.put("test2", 1);
        arrayListMultimap.put("test2", 3);
        arrayListMultimap.put("test2", 3);
        System.out.println(arrayListMultimap.toString());

        //按照原来的顺序
        LinkedListMultimap<String, Integer> linkedListMultimap = LinkedListMultimap.create();
        linkedListMultimap.put("test2", 3);
        linkedListMultimap.put("test2", 2);
        linkedListMultimap.put("test1", 1);
        linkedListMultimap.put("test5", 1);
        System.out.println(linkedListMultimap.toString());
    }
}
