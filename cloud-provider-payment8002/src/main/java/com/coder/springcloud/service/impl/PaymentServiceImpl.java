package com.coder.springcloud.service.impl;

import com.coder.springcloud.dao.PaymentDao;
import com.coder.springcloud.entity.Payment;
import com.coder.springcloud.service.intf.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : JQK
 * @date : 2020-07-23 20:23
 * @description :
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Integer insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment selectById(Long id) {
        return paymentDao.selectById(id);
    }
}
