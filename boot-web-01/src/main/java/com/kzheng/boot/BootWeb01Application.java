package com.kzheng.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.kzheng.boot.dao")
@SpringBootApplication
public class BootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(BootWeb01Application.class, args);
    }

}
