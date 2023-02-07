package com.andywang.jmsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class JmsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsSpringApplication.class, args);
    }
}
