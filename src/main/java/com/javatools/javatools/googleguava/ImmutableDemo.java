package com.javatools.javatools.googleguava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;

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
        testImmutable();
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
}
