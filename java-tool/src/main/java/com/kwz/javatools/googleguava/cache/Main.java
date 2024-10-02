package com.kwz.javatools.googleguava.cache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Description
 * Date 2020/12/8 23:52
 * Created by kwz
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> maps = Maps.newHashMap();
        maps.put("a", "a");
        maps.put("b", "b");
        maps.put("c", "c");

        GuavaCacheUtil.putAll(maps);

        String a = GuavaCacheUtil.get("a");
        GuavaCacheUtil.invalidateAll();
        System.out.println(a);
    }
}
