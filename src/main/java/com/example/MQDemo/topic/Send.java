package com.example.MQDemo.topic;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class Send {
    public static  final String EXCHANGE_NAME="text_exchange_topic";

    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        String msg="hello topic";
        for (int i=0;i<10;i++){
            channel.basicPublish(EXCHANGE_NAME,"good.add",null,(msg+i).getBytes());
        }
        System.out.println("finished");
        channel.close();
        connection.close();
    }
}
