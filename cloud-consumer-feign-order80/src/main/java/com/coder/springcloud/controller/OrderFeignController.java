package com.coder.springcloud.controller;

import com.coder.springcloud.entity.CommonResult;
import com.coder.springcloud.entity.Payment;
import com.coder.springcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JQK
 * @date : 2020-07-24 20:22
 * @description :
 */
@RestController
public class OrderFeignController {
    private OrderFeignService orderFeignService;

    @Autowired
    public OrderFeignController(OrderFeignService orderFeignService) {
        this.orderFeignService = orderFeignService;
    }

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult<Payment> getReset(@PathVariable Long id) {
        return orderFeignService.selectById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return orderFeignService.paymentFeignTimeout();
    }

}
