package com.kzheng.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/11 15:50
 */
class FooBar {
    private int n;
    Object obj=new Object();
    volatile boolean flag=true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (obj){
                while(!flag){
                    obj.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag=false;
                obj.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                while(flag){
                    obj.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag=true;
                obj.notifyAll();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(2);
        new Thread(()->{
            try {
                fooBar.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fooBar.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}