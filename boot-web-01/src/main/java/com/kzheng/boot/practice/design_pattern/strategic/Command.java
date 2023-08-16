package com.kzheng.boot.practice.design_pattern.strategic;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:38
 */
public interface Command {

    /**
     * 命令类型
     * @return
     */
    String operateType();

    /**
     * 执行
     * @param a
     * @param b
     * @return
     */
    Integer execute(int a, int b);

}
