package com.javatools.javatools.googleguava.collections;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Description
 * Date 2020/8/16 22:29
 * Created by kwz
 */
public class MapDemo {

    public static void main(String[] args) {
        testWithKeyValueSeparator();

    }

    private static void testWithKeyValueSeparator() {
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Cookies", "12332");
        testMap.put("Content-Length", "30000");
        testMap.put("Date", "2018.07.04");
        testMap.put("Mime", "text/html");
        // 用:分割键值对，并用#分割每个元素，返回字符串
        String returnedString = Joiner.on("#").withKeyValueSeparator(":").join(testMap);
        System.out.println(returnedString);
    }
}
