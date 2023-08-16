package com.kzheng.generic;

import java.util.List;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/14 15:49
 */
public abstract class AbstractMen {
    public void sing(){
        System.out.println(456);
    };

    public static void main(String[] args) {
        Men2 d=new Men2();
        d.eat(d);
        d.sing();
        List<String>[] stringLists = (List<String>[]) new List[10];
    }
}
