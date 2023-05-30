package com.kzheng.springcloud.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/18 14:24
 */
@RestController
@RefreshScope //git更新配置后还需要运维发送一个post请求手动刷新，才能生效curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
