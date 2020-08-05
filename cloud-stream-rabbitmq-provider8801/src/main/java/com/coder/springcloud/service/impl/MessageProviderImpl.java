package com.coder.springcloud.service.impl;

import com.coder.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author : JQK
 * @date : 2020-08-01 17:37
 * @description :
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {
    private MessageChannel output; // 消息发送管道

    @Autowired
    public MessageProviderImpl(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("=====serial: " + serial);
        return null;
    }
}
