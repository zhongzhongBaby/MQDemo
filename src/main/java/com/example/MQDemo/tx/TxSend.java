package com.example.MQDemo.tx;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class TxSend {
    public static final String QUEUE_NAMW = "test_queue_tx";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        String msg = "hello tx";
        try {
            channel.txSelect();
            //int i =1/0;
            channel.basicPublish("", QUEUE_NAMW, null, msg.getBytes());
            channel.txCommit();
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("消息没有发出去");
        }
        System.out.println("finished");
        channel.close();
        connection.close();
    }
}
