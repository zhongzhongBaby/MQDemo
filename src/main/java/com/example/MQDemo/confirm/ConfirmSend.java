package com.example.MQDemo.confirm;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


public class ConfirmSend {
    public static final String QUEUE_NAMW = "test_queue_confirm";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        String msg = "hello confirm";
        channel.confirmSelect();
        channel.basicPublish("", QUEUE_NAMW, null, msg.getBytes());
        if (!channel.waitForConfirms()){  //监听
            System.out.println("msg send failed");   //回调方法
        }else{
            System.out.println("msg send success");
        }
        System.out.println("finished");
        channel.close();
        connection.close();
    }
}
