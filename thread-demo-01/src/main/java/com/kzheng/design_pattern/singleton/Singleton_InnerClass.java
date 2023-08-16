package com.kzheng.design_pattern.singleton;

/**
 * @Author kaizheng
 * @Description 单例-内部类模式
 * @Date 2023/8/2 13:18
 */
public class Singleton_InnerClass {
    private static class Singleton{
        private static final Singleton_InnerClass singleton_InnerClass=new Singleton_InnerClass();
    }
    private Singleton_InnerClass(){}
    public static final Singleton_InnerClass getInstance(){
        return Singleton.singleton_InnerClass;
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton_InnerClass.getInstance().hashCode());
            }).start();
        }
    }
}
