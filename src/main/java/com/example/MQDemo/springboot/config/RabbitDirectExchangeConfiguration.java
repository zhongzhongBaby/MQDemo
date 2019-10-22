package com.example.MQDemo.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirectExchangeConfiguration {
    /**
     * 声明队列
     */
    @Bean(name = "message_4_1")
    public Queue message_4_1() {
        return new Queue("message_4_1");
    }
    @Bean("message_4_2")
    public Queue message_4_2() {
        return new Queue("message_4_2");
    }
    /**
     * 声明Direct交换器
     */
    @Bean
    public DirectExchange exchange_message4() {
        return new DirectExchange("exchange_message4");
    }
    /**
     * 绑定队列到交换器
     */
    @Bean
    public Binding binding4_1() {
        return BindingBuilder.bind(message_4_1()).to(exchange_message4()).with("error");
    }
    @Bean
    public Binding binding4_3() {
        return BindingBuilder.bind(message_4_1()).to(exchange_message4()).with("info");
    }
    @Bean
    public Binding binding4_2() {
        return BindingBuilder.bind(message_4_2()).to(exchange_message4()).with("error");
    }
}
