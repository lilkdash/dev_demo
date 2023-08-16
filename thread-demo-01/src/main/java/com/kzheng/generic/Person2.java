package com.kzheng.generic;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/7 13:38
 */
public abstract class Person2<T> {
    public abstract void print(T t);
    public void laugh(){
        System.out.println("hahhah");
    }
}
