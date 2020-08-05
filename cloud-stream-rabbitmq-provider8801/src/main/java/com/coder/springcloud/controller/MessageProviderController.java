package com.coder.springcloud.controller;

import com.coder.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JQK
 * @date : 2020-08-01 17:42
 * @description :
 */
@RestController
public class MessageProviderController {
    private MessageProvider messageProvider;

    public MessageProviderController(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @GetMapping(value = "/send")
    public String send() {
        messageProvider.send();
        return "发送成功";
    }

}
