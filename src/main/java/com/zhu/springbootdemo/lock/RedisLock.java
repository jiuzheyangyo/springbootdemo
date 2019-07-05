package com.zhu.springbootdemo.lock;

import com.alibaba.fastjson.serializer.JSONSerializer;
import javafx.util.Callback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


@Component
public class RedisLock {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    static RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);

    int maxAttempts = 2;

    long attemptIntervelsMillisecond = 1;

    long lockTimeSeconds = -1;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);

    private static final long TIMEOUT = 60;

    /**
     * 上锁
     */
    public <V> V lock(Object object,Callable<V> callable){

        byte[] sign = redisSerializer.serialize(object);

        String s = Base64Utils.encodeToString(sign);

        String key = "lock:" + s;

        String id = UUID.randomUUID().toString();
        int i = maxAttempts;
        while (i-- > 0) {
            try {
                Boolean isSet = stringRedisTemplate.opsForValue().setIfAbsent(key, id);
                if (isSet) {
                    //上锁成功,执行逻辑代码
                    stringRedisTemplate.expire(key,lockTimeSeconds,TimeUnit.SECONDS);
                    return callable.call();
                }
                LOGGER.info("{}:第{}次尝试上锁中。。。",key,maxAttempts-i+1);
                try {
                    TimeUnit.MILLISECONDS.sleep(attemptIntervelsMillisecond);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            } finally {

                DefaultRedisScript<String> script = new DefaultRedisScript<>();
                script.setResultType(String.class);
                script.setScriptText("if redis.call('get', KEYS[1]) == ARGV[1] then return tostring(redis.call('del', KEYS[1])) else return '0' end");
                List<String> objects = new ArrayList<>();
                objects.add(key);

                this.stringRedisTemplate.execute(script,objects, id);

//                String s1 = stringRedisTemplate.opsForValue().get(key);
//                if(s1 == id){
//                    stringRedisTemplate.delete(key);
//                }
            }
        }
        throw new IllegalStateException("Failed to get distributed lock for:" + new String(sign, Charset.defaultCharset()));
    }

    public void lock(String lockStr){
//        lock(lockStr,TIMEOUT);
    }

}
