package com.coder.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : JQK
 * @date : 2020-07-24 15:56
 * @description :
 */
@RestController
public class OrderController {

    private final RestTemplate restTemplate;
    private final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/order/zk")
    public String getResult() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }

}
