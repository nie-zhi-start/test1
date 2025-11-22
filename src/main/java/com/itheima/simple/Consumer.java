package com.itheima.simple;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        //谁来收
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //从哪里收
        consumer.setNamesrvAddr("localhost:9876");
        //监听哪个消息队列
        consumer.subscribe("topic1","*");

        //处理业务流程
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //业务逻辑
                for (MessageExt messageExt : list){
                    System.out.println(messageExt);
                    byte[] body = messageExt.getBody();
                    System.out.println(new String(body));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.println("消费者启动成功");

    }
}
