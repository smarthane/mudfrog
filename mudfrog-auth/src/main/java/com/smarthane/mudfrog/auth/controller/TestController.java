package com.smarthane.mudfrog.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 10:17
 * @Description:
 *
 *
 * http://localhost:10261/refresh post 刷新 config repo
 *
 */
@RestController
@RefreshScope
public class TestController {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${test}")
    private String test;

    @GetMapping("/test")
    public String test() {
        return this.test;
    }

    @GetMapping("/redis")
    public String testRedis() {
        this.redisTemplate.opsForValue().set("test", "3333333333333");
        return "ok";
    }

}
