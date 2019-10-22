package com.example.MQDemo.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitFanoutExchangeConfiguration {
    /**
     * 声明队列
     *
     * @return
     */
    @Bean(name = "message_3_1")
    public Queue message_3_1() {
        return new Queue("message_3_1");
    }

    @Bean("message_3_2")
    public Queue message_3_2() {
        return new Queue("message_3_2");
    }

    /**
     * 声明fanout交换器
     *
     * @return
     */
    @Bean
    public FanoutExchange exchange_message3() {
        return new FanoutExchange("exchange_message3");
    }

    /**
     * 绑定队列到交换器
     *
     * @return
     */
    @Bean
    public Binding binding3_1() {
        return BindingBuilder.bind(message_3_1()).to(exchange_message3());
    }

    @Bean
    public Binding binding3_2() {
        return BindingBuilder.bind(message_3_2()).to(exchange_message3());
    }
}
