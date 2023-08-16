package com.kzheng.boot.practice.design_pattern.strategic;

import org.springframework.stereotype.Component;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:38
 */
@Component
public class SubCommand implements Command {

    @Override
    public String operateType() {
        return "subtract";
    }

    @Override
    public Integer execute(int a, int b) {
        return a - b;
    }
}
