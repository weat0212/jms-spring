package com.andywang.jmsspring.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${springjms.myQueue}")
    private String queue;

    public void send(String message) {
        log.info("Send Message: " + message);
        MessageCreator messageCreator = session -> session.createTextMessage(message);
        jmsTemplate.send(queue, messageCreator);
    }
}
