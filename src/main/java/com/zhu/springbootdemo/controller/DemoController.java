package com.zhu.springbootdemo.controller;

import com.zhu.springbootdemo.lock.RedisLock;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demoController")
public class DemoController {

    @Autowired
    RedisLock redisLock;



    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("demo")
    public void demo(){
        stringRedisTemplate.opsForValue().set("zhu:name","小明");

        String s = stringRedisTemplate.opsForValue().get("zhu:name");
        System.out.println(s);

        String xiaozhu1 = redisLock.lock("111", () -> {
            String xiaozhu = testLock("xiaozhu");
            return xiaozhu;
        });

    }

    public String testLock(String str){

        System.out.println("执行中。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束。。。");
        return "success";

    }
}
