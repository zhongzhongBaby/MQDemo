package com.example.MQDemo.work;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    public static final String QUEUE_NAMW = "test_simple_queue2";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        for (int i = 0; i < 50; i++) {
            String msg = "hello world"+ i;
            channel.basicPublish("", QUEUE_NAMW, null, msg.getBytes());
        }
        channel.close();
        connection.close();
    }


}
