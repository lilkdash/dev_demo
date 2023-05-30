package com.kzheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/18 13:33
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344{
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class);
    }
}
