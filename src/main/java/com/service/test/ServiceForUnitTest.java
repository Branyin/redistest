package com.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

/**
 * Created by earringyin on 2019/4/21.
 */
@Service
public class ServiceForUnitTest {
    @Autowired
    RedisTemplate redisTemplate;




    public void testRedisTemplate(){
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("hello",redisTemplate.getConnectionFactory(),1);
        redisAtomicLong.getAndIncrement();
        System.out.println(redisAtomicLong.intValue());
    }
}
