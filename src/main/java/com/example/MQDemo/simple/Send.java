package com.example.MQDemo.simple;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    public static final String QUEUE_NAMW = "test_simple_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        String msg = "hello world";
        channel.basicPublish("",QUEUE_NAMW,null,msg.getBytes());
        System.out.println("--send msg :"+msg);
        channel.close();
        connection.close();
    }


}
