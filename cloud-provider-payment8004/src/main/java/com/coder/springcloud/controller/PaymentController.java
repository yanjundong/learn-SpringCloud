package com.coder.springcloud.controller;

import com.coder.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : JQK
 * @date : 2020-07-24 15:11
 * @description :
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String getResult() {
        return "consumer, serverPost: " + serverPort + "\n" + UUID.randomUUID();

    }

}
