package com.coder.springcloud.controller;

import com.coder.springcloud.entity.CommonResult;
import com.coder.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author : JQK
 * @date : 2020-07-23 21:21
 * @description :
 */
@RestController
public class OrderConsulController {

    private final RestTemplate restTemplate;
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public OrderConsulController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @PostMapping(value = "/consumer/payment")
    public CommonResult insert(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
    }

}
