package com.smarthane.mudfrog.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with by smarthane-cloud.
 * @author: smarthane
 * @Date: 2018/6/5 15:50
 * @Description:
 */

@EnableEurekaServer
@SpringBootApplication
public class MudfrogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MudfrogEurekaApplication.class, args);
    }
}
