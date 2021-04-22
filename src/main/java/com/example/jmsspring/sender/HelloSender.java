package com.example.jmsspring.sender;

import com.example.jmsspring.config.JmsConfig;
import com.example.jmsspring.model.HelloWorldMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

/**
 * @author I-Chung, Wang
 * @date 2021/4/21 下午 03:12
 */

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello JMS World")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

    }

    @Scheduled(fixedRate = 2000)
    public void sendReceiveMessage() throws JMSException {

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello")
                .build();

        Message receiveMsg = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RCV_QUEUE, new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {

                Message hello = null;

                try {
                    hello = session.createTextMessage(objectMapper.writeValueAsString(message));
                    hello.setStringProperty("_type", "com.example.jmsspring.model.HelloWorldMessage");

                    System.out.println("Sending Hello");
                    return hello;

                } catch (JsonProcessingException e) {
                    throw new JMSException("BOOM");
                }

            }
        });

        System.out.println(receiveMsg.getBody(String.class));
    }
}
