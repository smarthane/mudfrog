package com.smarthane.mudfrog.sapmles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/7 14:55
 * @Description:
 */
@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${test}")
    private String test;

    @GetMapping("/test")
    public String test() {
        return this.test;
    }
    
}
