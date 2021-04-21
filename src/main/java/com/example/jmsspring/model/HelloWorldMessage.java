package com.example.jmsspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author I-Chung, Wang
 * @date 2021/4/21 下午 02:26
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {

    static final long serialVersionUID = -2460570518504462822L;

    private UUID id;
    private String message;
}
