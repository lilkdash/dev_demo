package com.kzheng.design_pattern.singleton;

import sun.dc.pr.PRError;

/**
 * @Author kaizheng
 * @Description 单例-内部枚举类
 * @Date 2023/8/2 13:23
 */
public class Singleton_Inner_Enum {
    private Singleton_Inner_Enum(){}
    public static enum Singleton{
        SINGLETON;
        private Singleton_Inner_Enum singleton_Inner_Enum=null;
        private Singleton(){
            singleton_Inner_Enum=new Singleton_Inner_Enum();
        }
        public Singleton_Inner_Enum getInstance(){
            return singleton_Inner_Enum;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton.SINGLETON.getInstance().hashCode());
            }).start();
        }
    }
}
