package com.kzheng.other;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/26 17:05
 */
public class Excercise {

    public static class Child extends Person{
        public String grade;

    }
    public static void main(String[] args) {
        Person p = new Child();
        //System.out.println(p.name);
        int x = 4;
        System.out.println("value is"+((x>4)?99.9:9));

    }
}
