package com.kzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/22 17:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class, args);
    }
}
