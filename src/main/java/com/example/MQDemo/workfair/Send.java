package com.example.MQDemo.workfair;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    public static final String QUEUE_NAMW = "test_simple_queue2";


    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        int prefectchCount=1;  //每个消费者不发送确认消息之前，消息队列不发送下一个消息到这个消息消费者，一次只处理一个消息
        channel.basicQos(prefectchCount);
        for (int i = 0; i < 50; i++) {
            String msg = "hello world"+ i;
            channel.basicPublish("", QUEUE_NAMW, null, msg.getBytes());
        }
        channel.close();
        connection.close();
    }


}
