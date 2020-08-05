package com.coder.springcloud.service.intf;

import com.coder.springcloud.entity.Payment;

/**
 * @author : JQK
 * @date : 2020-07-23 20:22
 * @description :
 */
public interface PaymentService {

    public Integer insert(Payment payment);

    public Payment selectById(Long id);

}
