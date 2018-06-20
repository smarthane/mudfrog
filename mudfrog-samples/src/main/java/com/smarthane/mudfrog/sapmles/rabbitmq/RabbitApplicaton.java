package com.smarthane.mudfrog.sapmles.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/8 9:44
 * @Description:
 */
@SpringBootApplication
public class RabbitApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplicaton.class, args);
    }



}
