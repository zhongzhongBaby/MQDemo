package com.example.MQDemo.simple;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQImpl.Basic.Deliver;

import java.io.IOException;

public class Receive {
    public static final String QUEUE_NAMW = "test_simple_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAMW ,false,false,false,null);
        Consumer consumer = new DefaultConsumer(channel) {
            //事件模型，一旦监听到消息就会触发这个handleDelivery方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消息内容为：" + new String(body));
            }
        };
        //消费者监听队列
        channel.basicConsume(QUEUE_NAMW, true, consumer);
    }
}
