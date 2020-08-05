package com.coder.springcloud.controller;

import com.coder.springcloud.entity.CommonResult;
import com.coder.springcloud.entity.Payment;
import com.coder.springcloud.service.intf.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author : JQK
 * @date : 2020-07-23 20:26
 * @description :
 */
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult selectById(@PathVariable Long id) {
        Payment payment = paymentService.selectById(id);
        if (null != payment) {
            return new CommonResult(200, "查询成功，server.post：" + serverPort, payment);
        } else {
            return new CommonResult(500, "查询失败");
        }
    }

    @PostMapping(value = "/payment")
    public CommonResult<Payment> insert(@RequestBody Payment payment) {
        Integer insert = paymentService.insert(payment);
        if (insert > 0) {
            return new CommonResult(200, "插入成功，server.post：" + serverPort, payment);
        } else {
            return new CommonResult(500, "插入失败，server.port：" + serverPort);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
