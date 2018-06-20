package com.smarthane.mudfrog.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 10:08
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MudfrogAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MudfrogAuthApplication.class, args);
    }
}
