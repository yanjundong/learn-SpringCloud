package com.coder.springcloud.dao;

import com.coder.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : JQK
 * @date : 2020-07-23 19:57
 * @description :
 */
@Mapper
public interface PaymentDao {

    public Integer insert(Payment payment);

    public Payment selectById(@Param("id") Long id);

}
