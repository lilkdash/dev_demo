package com.kzheng.design_pattern.strategic;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:27
 */
public class DivOperation implements Operation {

    @Override
    public int execute(int a, int b) {
        return a / b;
    }
}