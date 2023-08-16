package com.kzheng.boot.common.log;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/31 17:12
 */
@Component
@Aspect
@Slf4j
public class MethodLogAspect {
    /**
     * 自定义切点
     */
    @Pointcut("@annotation(com.kzheng.boot.common.annotation.MethodLog)")
    public void MethodLog(){

    }
    @Before("MethodLog()")
    public void doBefore(JoinPoint joinpoint){
        //记录方法入参
        log.info("Request Method:{},Request Param:{}",joinpoint.getSignature(), JSONObject.toJSONString(joinpoint.getArgs() ));
    }
    @AfterReturning(returning = "o",pointcut = "MethodLog()")
    public void doBefore(Object o){
        //记录方法返回
        log.info("Response Result:{}",JSONObject.toJSONString(o));
    }
}
