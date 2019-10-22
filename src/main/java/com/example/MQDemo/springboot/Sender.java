package com.example.MQDemo.springboot;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    Logger logger = LoggerFactory.getLogger(Sender.class);
    private  int   count=0;
    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send1(){
        String context = "简单队列的消息";
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }

    public String send2(){
        String context = "工作队列的消息";
        amqpTemplate.convertAndSend("message2", context);
        return "发送成功";
    }



    public String send3(){
        String context = "fanout交换器的消息";
        amqpTemplate.convertAndSend("exchange_message3","", context);
        return "发送成功";
    }


    public String send4(String key){
        String context = "direct交换器的消息";
        amqpTemplate.convertAndSend("exchange_message4",key, context);
        return "发送成功";
    }


    public String send5(String key){
        String context = "topic交换器的消息";
        amqpTemplate.convertAndSend("exchange_message5",key, context);
        return "发送成功";
    }











}