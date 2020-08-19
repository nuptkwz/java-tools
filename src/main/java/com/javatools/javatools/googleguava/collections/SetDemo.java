package com.javatools.javatools.googleguava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Description
 * Date 2020/8/16 22:29
 * Created by kwz
 */
public class SetDemo {

    public static void main(String[] args) {
        testHashMultiset();
    }

    private static void testHashMultiset() {
        //通过create()方法创建
        Multiset<String> multiset = HashMultiset.create();
        //可直接添加元素
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("c");
        multiset.add("c");
        List<String> list = new ArrayList<String>();
        list.add("xx");
        list.add("yy");
        list.add("zz");
        //也可用addAll方法添加集合进来
        multiset.addAll(list);
        //获取元素"c"的计数
        System.out.println(multiset.count("c"));

        //返回去重后的元素set集合
        Set<String> set = multiset.elementSet();

        //multiset所有元素的个数
        System.out.println("multiset.size():" + multiset.size());
        //multiset去重后的元素个数
        System.out.println("elementSet().size():" + multiset.elementSet().size());

        //元素迭代
        Iterator<String> it = multiset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //可以通过设置元素的计数，来批量的添加元素，当然能加也能减
        multiset.setCount("c", 5);

        //将元素的计数设为0，就相当于移除所有的"c"元素
//        multiset.setCount("c", 0);

        //移除一个元素
//        multiset.remove("c");

        //移除两个"c"元素
        multiset.remove("c", 2);

        System.out.println(multiset);
    }
}
