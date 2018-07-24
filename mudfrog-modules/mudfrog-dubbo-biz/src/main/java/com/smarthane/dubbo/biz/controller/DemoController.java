package com.smarthane.dubbo.biz.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.smarthane.dubbo.api.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/7/10 14:28
 * @Description:
 */
@RestController
public class DemoController {

    @Reference(version = "${demo.service.version}", application = "${dubbo.application.id}", url = "dubbo://localhost:12345")
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }
    
}
