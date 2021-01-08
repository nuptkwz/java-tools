package com.javatools.javatools.googleguava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.Set;

/**
 * Description
 * Date 2020/9/4 23:50
 * Created by kwz
 */
public class MultisetDemo {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");
        System.out.println("Occurrence of 'b' : " + multiset.count("b"));
        System.out.println("Total Size : " + multiset.size());
        Set<String> set = multiset.elementSet();
        System.out.println("Set [");
        System.out.println(set);
        System.out.println("]");
        Iterator<String> iterator = multiset.iterator();
        System.out.println("MultiSet [");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("]");
        System.out.println("MultiSet [");
        for (Multiset.Entry<String> entry : multiset.entrySet()) {
            System.out.println("Element: " + entry.getElement() + ", Occurrence(s): " + entry.getCount());
        }
        System.out.println("]");
        multiset.remove("b", 2);
        System.out.println("Occurrence of 'b' : " + multiset.count("b"));
    }
}
