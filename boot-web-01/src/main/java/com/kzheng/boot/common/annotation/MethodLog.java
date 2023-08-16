package com.kzheng.boot.common.annotation;

import java.lang.annotation.*;

/**
 * @Author kaizheng
 * @Description 自定义日志注解
 * @Date 2023/7/31 17:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodLog {

}
