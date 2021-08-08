package com.kwz.javatool.googleguava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * Date 2020/12/8 23:52
 * Created by kwz
 */
@UtilityClass
public class GuavaCacheUtil {

    final static Cache<String, String> cache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(256)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为10秒
            .expireAfterWrite(1, TimeUnit.HOURS)
            //构建cache实例
            .build();

    public void putAll(Map<String, String> map) {
        cache.putAll(map);
    }

    public String get(String key) {
        return cache.getIfPresent(key);
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }
}
