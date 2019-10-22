package com.example.MQDemo.springboot;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @RabbitListener(queuesToDeclare = @Queue("message"))
    @RabbitHandler
    public void process(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，发送短信通知用户");
    }
    @RabbitListener(queuesToDeclare = @Queue("message2"))
    @RabbitHandler
    public void process2_1(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者1发送短信通知用户");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @RabbitListener(queuesToDeclare = @Queue("message2"))
    @RabbitHandler
    public void process2_2(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者2发送短信通知用户");
    }

    @RabbitListener(queuesToDeclare = @Queue("message_3_1"))
    @RabbitHandler
    public void process3_1(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者1发送【短信】通知用户");
    }


    @RabbitListener(queuesToDeclare = @Queue("message_3_2"))
    @RabbitHandler
    public void process3_2(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者2发送【邮件】通知用户");
    }

    @RabbitListener(queuesToDeclare = @Queue("message_4_1"))
    @RabbitHandler
    public void process4_1(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者1发送【短信】通知用户");
    }

    @RabbitListener(queuesToDeclare = @Queue("message_4_2"))
    @RabbitHandler
    public void process4_2(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者2发送【邮件】通知用户");
    }


    @RabbitListener(queuesToDeclare = @Queue("message_5_1"))
    @RabbitHandler
    public void process5_1(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者1发送【短信】通知用户");
    }

    @RabbitListener(queuesToDeclare = @Queue("message_5_2"))
    @RabbitHandler
    public void process5_2(String str) {
        System.out.println("处理信息中......"+str);
        System.out.println("处理成功，通过消费者2发送【邮件】通知用户");
    }












}
