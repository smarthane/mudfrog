package com.smarthane.mudfrog.sapmles.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with by smarthane-cloud.
 *
 * @author: smarthane
 * @Date: 2018/6/8 10:02
 * @Description:
 */
@Configuration
public class RabbitConfig {

    //声明队列
    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true); // true表示持久化该队列
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    //声明交互器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    //绑定
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }

//
//    如果需要使用的其他的交换器类型，spring中都已提供实现，所有的交换器均实现org.springframework.amqp.core.AbstractExchange接口。
//
//    常用交换器类型如下：
//
//    Direct(DirectExchange)：direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key完全匹配时, 才会被交换器投送到绑定的队列中去。
//
//    Topic(TopicExchange)：按规则转发消息（最灵活）。
//
//    Headers(HeadersExchange)：设置header attribute参数类型的交换机。
//
//    Fanout(FanoutExchange)：转发消息到所有绑定队列。

}
