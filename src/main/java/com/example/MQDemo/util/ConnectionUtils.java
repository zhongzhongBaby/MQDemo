package com.example.MQDemo.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {

    public static Connection getConection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);  //amqp 通信协议
        factory.setVirtualHost("/vhost_gyz");   //相当于连接哪个数据库    这儿就是vhost
        factory.setUsername("gengyuzhong");
        factory.setPassword("123456");
        return factory.newConnection();
    }

}
