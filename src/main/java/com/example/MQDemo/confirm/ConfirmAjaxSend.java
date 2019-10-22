package com.example.MQDemo.confirm;

import com.example.MQDemo.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConfirmAjaxSend {
    public static final String QUEUE_NAMW = "test_queue_confirm_ajax";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        String msg = "hello confirm";
        //设定模式
        channel.confirmSelect();
        //未确认消息集合
        final SortedSet<Long> unConfirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
        //添加监听器
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                if (b) {
                    System.out.println("handleAck" + "批量");
                } else {
                    System.out.println("handleAck" + "单个");
                }
            }
            @Override
            public void handleNack(long l, boolean b) throws IOException {
                if (b) {
                    System.out.println("handleNack" + "批量");
                } else {
                    System.out.println("handleNack" + "单个");
                }
            }
        });
        int i = 100;
        while (i > 0) {
            Long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAMW, null, (msg + i).getBytes());
            unConfirmSet.add(seqNo);
            i--;
        }
        System.out.println("finished");
        channel.close();
        connection.close();
    }


}
