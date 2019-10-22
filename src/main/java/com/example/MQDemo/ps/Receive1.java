package com.example.MQDemo.ps;


import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Receive1 {
    public static final String QUEUE_NAMW = "test_queue_ps_mail";//同一条消息既要被邮件消费者消费，也要被短信业务消费
    public static  final String EXCHANGE_NAME="text_exchange_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAMW ,false,false,false,null);
        channel.queueBind(QUEUE_NAMW ,EXCHANGE_NAME ,"");
        channel.basicQos(1);
        Consumer consumer = new DefaultConsumer(channel) {
            //事件模型，一旦监听到消息就会触发这个handleDelivery方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer1收到的消息内容为：" + new String(body));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        Boolean autoAck=false;
        //消费者监听队列
        channel.basicConsume(QUEUE_NAMW, autoAck, consumer);
    }
}
