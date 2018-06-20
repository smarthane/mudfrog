package com.smarthane.mudfrog.sapmles.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/8 9:42
 * @Description:
 */
@Component
public class Receiver {

    private final Logger logger = Logger.getLogger(getClass());

    @RabbitListener(queues = "hello.queue1")
    public String processMessage1(String msg) {
        logger.info(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
        return msg.toUpperCase();
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        logger.info(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
    }
    
}
