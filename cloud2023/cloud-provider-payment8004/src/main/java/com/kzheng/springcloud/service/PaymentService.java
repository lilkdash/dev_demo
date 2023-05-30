package com.kzheng.springcloud.service;

import com.kzheng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 14:06
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
