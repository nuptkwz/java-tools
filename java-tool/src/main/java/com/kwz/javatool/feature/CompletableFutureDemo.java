package com.kwz.javatool.feature;

import java.util.concurrent.CompletableFuture;

/**
 * Description
 * Date 2021/5/21 7:56
 * Created by kwz
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        supplyAsyncThenAccept();
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
}
