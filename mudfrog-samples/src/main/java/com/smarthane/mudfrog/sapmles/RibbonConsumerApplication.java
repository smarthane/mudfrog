package com.smarthane.mudfrog.sapmles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 10:16
 * @Description:
 */

@EnableCircuitBreaker //开启断路器功能 hystrix
@EnableHystrix
@EnableHystrixDashboard // 开启断路器 HystrixDashboard
@EnableDiscoveryClient  //开启服务发现功能
@SpringBootApplication
//@SpringCloudApplication 该注解包含上述三个注解，这也意味着一个SpringCloud标准应用应包含服务发现以及断路器
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

}
