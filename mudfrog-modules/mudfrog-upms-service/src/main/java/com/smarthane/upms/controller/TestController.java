package com.smarthane.upms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/7/24 15:46
 * @Description:
 */
@RestController
public class TestController {

    @Value("${test}")
    private String test;

    @GetMapping("/test")
    public String test() {
        return this.test;
    }
}
