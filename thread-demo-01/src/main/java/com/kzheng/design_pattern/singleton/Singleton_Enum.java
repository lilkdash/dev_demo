package com.kzheng.design_pattern.singleton;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/2 13:08
 */
public enum Singleton_Enum {
    INSTANCE;
    public void print(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton_Enum.INSTANCE.hashCode());
            }).start();
        }
    }
}
