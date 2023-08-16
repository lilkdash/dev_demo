package com.kzheng.boot.practice.design_pattern.strategic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:51
 */
@Component
public class CommandFactory {

    /**
     * Spring会自动将Strategy接口的实现类注入到这个Map中，key为bean id，value值则为对应的策略实现类
     */
    @Autowired
    private Map<String, Command> commandMap;


    /**
     * 执行计算
     * @param operateType
     * @param a
     * @param b
     * @return
     */
    public int calculate(String operateType,int a, int b){
        System.out.println(commandMap);
        Command targetCommand = Optional.ofNullable(commandMap.get(operateType))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetCommand.execute(a,b);
    }
}