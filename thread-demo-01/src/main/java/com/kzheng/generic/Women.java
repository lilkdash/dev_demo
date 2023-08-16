package com.kzheng.generic;

import java.util.ArrayList;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/7 13:49
 */
public class Women extends Person2<String> implements Worker<Integer>,Doctor{

    public static void main(String[] args) {
        Women women = new Women();
        women.sleep(1);
        Women women2 = new Women();
        women.sleep(1);
    }

    @Override
    public void sleep(Object o) {
        System.out.println(o.toString()+":i am sleeping");
    }



    @Override
    public void working(Integer name) {

    }

    @Override
    public void print(String s) {

    }
}
