package com.itheima.simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {

        //谁来发
        DefaultMQProducer producer =new DefaultMQProducer("group1");
        //发给谁
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        //怎么发
        //发什么
        String msg = "hello world yuanlajd";
        Message message = new Message("topic1", "tag1", msg.getBytes());
        SendResult sendResult = producer.send(message);

        System.out.println(sendResult);
        //关闭生产者
        producer.shutdown();
    }
}
