package com.kzheng.springcloud.service.impl;

import com.kzheng.springcloud.dao.PaymentDao;
import com.kzheng.springcloud.entities.Payment;
import com.kzheng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 14:08
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
