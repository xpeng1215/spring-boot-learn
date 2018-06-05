package com.ucmed.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther ucmed xpeng
 * @create 2018/5/8
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class SpringBootRedisTest {

  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void set(){
    redisTemplate.opsForValue().set("test:set","testValue1");
  }
}
