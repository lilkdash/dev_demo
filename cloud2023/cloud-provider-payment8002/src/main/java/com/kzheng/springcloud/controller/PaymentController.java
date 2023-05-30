package com.kzheng.springcloud.controller;

import com.kzheng.springcloud.entities.CommonResult;
import com.kzheng.springcloud.entities.Payment;
import com.kzheng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 14:14
 */
@RestController
@Slf4j
//@CrossOrigin//运行所有域名访问，后面可以加上括号并限定域名,这里加上是方便postman发送测试请求
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    /**
     * 这里的@RequestBody加上后通过浏览器前端发送的请求可以正常将参数转为Payment对象，但是postman本身传过来的就是json对象，这样做反而报错
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,servicePort:"+serverPort);
        }else{
            return new CommonResult(444,"插入数据库失败,servicePort:"+serverPort);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,servicePort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询ID:"+id+",servicePort:"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }
}
