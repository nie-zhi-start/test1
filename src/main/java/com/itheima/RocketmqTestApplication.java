package com.itheima;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketmqTestApplication {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        SpringApplication.run(RocketmqTestApplication.class, args);

    }

}
