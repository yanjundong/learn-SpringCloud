package com.coder.springcloud.controller;

import com.coder.springcloud.entity.CommonResult;
import com.coder.springcloud.entity.Payment;
import com.coder.springcloud.service.intf.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : JQK
 * @date : 2020-07-23 20:26
 * @description :
 */
@RestController
public class PaymentController {

    private final PaymentService paymentService;
    private final DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public PaymentController(final PaymentService paymentService, final DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
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
            return new CommonResult(500, "插入失败");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/discovery")
    public Object discoveryService() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 休眠3秒
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
}
