package com.smarthane.mudfrog.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/7 11:53
 * @Description:
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class MudfrogConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MudfrogConfigApplication.class, args);
    }

}
