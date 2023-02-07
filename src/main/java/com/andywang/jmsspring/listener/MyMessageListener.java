package com.andywang.jmsspring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MyMessageListener {

    @JmsListener(destination = "${springjms.myQueue}")
    public void receive(String message) {
       log.info("Message Received: " + message);
    }
}
