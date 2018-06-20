package com.smarthane.mudfrog.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/6 16:10
 * @Description:
 */

@EnableZuulProxy
@SpringCloudApplication
public class MudfrogGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MudfrogGatewayApplication.class)
                .web(true)
                .run(args);
        //SpringApplication.run(ZuulApplication.class, args);
    }
}
