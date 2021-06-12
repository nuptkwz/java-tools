package com.javatools.javatools.concurrency;

import java.util.stream.LongStream;

/**
 * Description
 * ForkJoin 在1.7，并行执行任务！提高速率，大数据量
 * 特点：工作窃取，原因是里面维护的是双端队列
 * Date 2021/3/30 22:53
 * Created by kwz
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_000_000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间：" + (end - start));
        System.out.println();
    }
}
