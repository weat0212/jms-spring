package com.andywang.jmsspring;

import com.andywang.jmsspring.sender.MessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JmsSpringApplicationTests {

    @Autowired
    MessageSender messageSender;

    @Test
    void testSendAndReceived() {
        messageSender.send("Hello Spring JMS!!!");
    }
}
