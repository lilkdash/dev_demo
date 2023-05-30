package com.kzheng.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/16 17:46
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80------PaymentFallbackService fall back-ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80------PaymentFallbackService fall back-timeout";
    }
}
