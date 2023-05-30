package com.kzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/18 13:33
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCenterMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3366.class,args);
    }
}
