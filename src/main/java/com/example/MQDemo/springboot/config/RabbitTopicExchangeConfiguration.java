package com.example.MQDemo.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicExchangeConfiguration {
    /**
     * 声明队列
     */
    @Bean(name = "message_5_1")
    public Queue message_5_1() {
        return new Queue("message_5_1");
    }

    @Bean("message_5_2")
    public Queue message_5_2() {
        return new Queue("message_5_2");
    }

    /**
     * 声明Direct交换器
     */
    @Bean
    public DirectExchange exchange_message5() {
        return new DirectExchange("exchange_message5");
    }

    /**
     * 绑定队列到交换器
     */
    @Bean
    public Binding binding5_1() {
        return BindingBuilder.bind(message_5_1()).to(exchange_message5()).with("goods.add");
    }

    @Bean
    public Binding binding5_3() {
        return BindingBuilder.bind(message_5_1()).to(exchange_message5()).with("goods.delete");
    }
    @Bean
    public Binding binding5_2() {
        return BindingBuilder.bind(message_5_2()).to(exchange_message5()).with("goods.#");
    }
}
