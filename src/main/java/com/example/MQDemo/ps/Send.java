package com.example.MQDemo.ps;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class Send {
    public static  final String EXCHANGE_NAME="text_exchange_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String msg="hello ps";
        for (int i=0;i<10;i++){
            channel.basicPublish(EXCHANGE_NAME,"",null,(msg+i).getBytes());
        }
        System.out.println("finished");
        channel.close();
        connection.close();
    }
}
