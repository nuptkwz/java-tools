package com.kwz.javatool.feature;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Description
 * Date 2021/5/21 7:56
 * Created by kwz
 */
@Slf4j
public class CompletableFutureDemo {
    public static void main(String[] args) {
//        supplyAsyncThenAccept();
//        testCompletableFuture();
        completableFuturePlus();
    }

    private static void supplyAsyncThenAccept() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("电饭煲开始煮饭");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "米饭";
                }
        ).thenAccept(
                result -> System.out.println("开始吃:" + result)
        );
        System.out.println("我先去搞点牛奶和鸡蛋");
        future.join();
    }

    private static void testCompletableFuture() {
        //异步任务，无返回值，内部使用forkJoin线程池
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> doSomething("打开电饭锅开关"));

        //异步任务有返回值，使用内部的线程池
        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> doSomethingWithReturn("开始淘米", "得到干净的米"));
        try {
            //有异常则抛出，无限的等待
            System.out.println("supplyAsyncFuture:" + supplyAsyncFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //只要有一个完成，则完成，有一个抛出异常，则携带异常
        CompletableFuture.anyOf(runAsyncFuture, supplyAsyncFuture);

        // 等待所有的future全部完成才可以
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(runAsyncFuture, supplyAsyncFuture);
        //不抛出异常，阻塞的等待
        allOfFuture.join();

        System.out.println("hello main function");
    }

    /**
     * 模拟completableFuture接续方式
     */
    private static void completableFuturePlus() {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> doSomethingWithReturn("打开电饭锅开关", "米"));
        supplyAsync.thenAcceptAsync(result -> {
            System.out.println("拿到" + result);
            doSomething("开始煮米饭");
        }).thenRunAsync(
                () -> {
                    System.out.println("可以吃饭了");
                }
        );
    }

    private static void doSomething(String doSomething) {
        try {
            Thread.sleep(2000);
            System.out.println(doSomething);
        } catch (Exception e) {
            log.error("do something error", e);
        }
    }

    private static String doSomethingWithReturn(String doSomething, String returnSomething) {
        try {
            Thread.sleep(2000);
            System.out.println(doSomething);
            return returnSomething;
        } catch (Exception e) {
            log.error("do something error", e);
        }
        return null;
    }
}
