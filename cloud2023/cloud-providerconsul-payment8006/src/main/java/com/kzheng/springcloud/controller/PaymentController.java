package com.kzheng.springcloud.controller;

import com.kzheng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 14:14
 */
@RestController
@Slf4j
//@CrossOrigin//运行所有域名访问，后面可以加上括号并限定域名,这里加上是方便postman发送测试请求
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
