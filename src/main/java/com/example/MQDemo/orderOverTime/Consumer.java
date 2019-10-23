package com.example.MQDemo.orderOverTime;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queuesToDeclare = @Queue("message_order_overTime"))
    @RabbitHandler
    public void process(String str) {
        System.out.println("处理订单中......"+str);
        System.out.println("判断订单是否仍然处于未支付状态......");
        System.out.println("处理成功，发送短信通知用户");
    }
}
