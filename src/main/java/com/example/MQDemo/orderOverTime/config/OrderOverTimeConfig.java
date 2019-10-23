package com.example.MQDemo.orderOverTime.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OrderOverTimeConfig {
    /**
     * 声明队列
     *
     * @return
     */
    @Bean(name = "message_order")
    public Queue message_order() {
        Map<String, Object> arguments = new HashMap<>();
        //为队列配置消息过期时间和死信交换
        arguments.put("x-dead-letter-exchange", "exchange_deadMessage");
        //arguments.put("x-dead-letter-routing-key", "routing_dead");
        arguments.put("x-message-ttl", 50000);
        return new Queue("message_order", true, false, false, arguments);
    }

    @Bean("message_order_overTime")
    public Queue message_order_overTime() {
        return new Queue("message_order_overTime");
    }

    /**
     * 死信交换器
     *
     * @return
     */
    @Bean
    public FanoutExchange exchange_deadMessage() {
        return new FanoutExchange("exchange_deadMessage");
    }

    /**
     * 绑定队列到死信交换器
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(message_order_overTime()).to(exchange_deadMessage());
    }


}
