package com.kzheng.boot.practice.design_pattern.strategic;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:39
 */
@Component
public class CalculatorService implements ApplicationContextAware {

    private Map<String, Command> commandMap = new ConcurrentHashMap<>();


    /**
     * 执行计算
     * @param operateType
     * @param a
     * @param b
     * @return
     */
    public int calculate(String operateType,int a, int b){
        Command targetCommand = Optional.ofNullable(commandMap.get(operateType))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetCommand.execute(a,b);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Command> tempMap = applicationContext.getBeansOfType(Command.class);
        tempMap.values().forEach(source -> commandMap.put(source.operateType(), source));
    }
}