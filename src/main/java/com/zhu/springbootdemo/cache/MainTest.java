package com.zhu.springbootdemo.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static LoadingCache<String, List<String>> cache  = CacheBuilder.newBuilder()
            .maximumSize(8)
                    .expireAfterWrite(3, TimeUnit.SECONDS)
                    .build(new CacheLoader<String, List<String>>() {
        @Override
        public List<String> load(String key) throws Exception {
            System.out.println("存值11111111。。。。。。。。。。。。");
            List<String> list = Lists.newArrayList();
            list.add("aaaabbbbbbb");
            return list;
        }
    });
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            List<String> values = cache.getUnchecked("key");
            System.out.println("1111111111"+JSON.toJSONString(values));
        }).start();


        Thread.sleep(9000);
        List<String> values = cache.getUnchecked("key");
        System.out.println(JSON.toJSONString(values));
        Thread.sleep(1000000);
    }
}
