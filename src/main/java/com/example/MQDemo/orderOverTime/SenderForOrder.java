package com.example.MQDemo.orderOverTime;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderForOrder {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "订单编号1";
        amqpTemplate.convertAndSend("message_order", context);
        return "发送成功";
    }
}
