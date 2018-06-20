package com.smarthane.mudfrog.sapmles.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;


/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/8 9:37
 * @Description:
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("消息发送成功:" + correlationData);
        } else {
            logger.info("消息发送失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(String msg){

//        rabbitTemplate.send(message);   //发消息，参数类型为org.springframework.amqp.core.Message
//        rabbitTemplate.convertAndSend(object); //转换并发送消息。 将参数对象转换为org.springframework.amqp.core.Message后发送
//        rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息。


        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        logger.info("开始发送消息 : " + msg.toLowerCase());
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
        logger.info("结束发送消息 : " + msg.toLowerCase());
        logger.info("消费者响应 : " + response + " 消息处理完成");
    }

}
