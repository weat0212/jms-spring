package com.example.jmsspring.listener;

import com.example.jmsspring.config.JmsConfig;
import com.example.jmsspring.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * @author I-Chung, Wang
 * @date 2021/4/22 下午 12:57
 */

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) {

        System.out.println("I Got a Message!");
        System.out.println("HelloWorldMessage: " + helloWorldMessage);
        System.out.println("Header: "+ headers);
        System.out.println("Message: "+ message);
        System.out.println("**********************END OF THE MESSAGE**********************");
        System.out.println();

        //throwing a exception means the transaction doesn't complete and
        //ActiveMQ will re-sent the message and if confirm form the client will not throwing the message
//        throw new RuntimeException("foo");
    }
}
