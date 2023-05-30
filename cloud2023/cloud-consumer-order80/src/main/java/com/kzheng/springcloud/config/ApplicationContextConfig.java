package com.kzheng.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/6 15:18
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
