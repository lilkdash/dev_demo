package com.kzheng.design_pattern.strategic;

/**
 * @Author kaizheng
 * @Description 策略模式
 * @Date 2023/8/1 20:17
 */
public interface Operation {

    /**
     * 执行计算
     * @param a
     * @param b
     * @return
     */
    int execute(int a, int b);
}