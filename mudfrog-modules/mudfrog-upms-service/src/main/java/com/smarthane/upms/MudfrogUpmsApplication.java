package com.smarthane.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/7/24 15:34
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MudfrogUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MudfrogUpmsApplication.class, args);
    }

}
