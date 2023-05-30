package com.kzheng.springcloud.dao;

import com.kzheng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 13:53
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
