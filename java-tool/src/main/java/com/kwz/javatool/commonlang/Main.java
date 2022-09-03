package com.kwz.javatool.commonlang;;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Description
 * Date 2020/9/2 23:14
 * Created by kwz
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(testTriple());
    }

    private static Triple<String, Integer, String> testTriple() {
        Triple<String, Integer, String> triple = ImmutableTriple.of("left", 1, "right");
        String left = triple.getLeft();
        Integer middle = triple.getMiddle();
        String right = triple.getRight();
        return triple;
    }

    private static void testPair() {
        Pair<Integer, String> pair = new Pair<>(1, "value");
        Integer key = pair.getKey();
        String value = pair.getValue();
        System.out.println(pair + "key:" + key + ",value:" + value);
    }
}
