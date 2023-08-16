package com.kzheng.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/11 14:53
 */
class Foo {
    CountDownLatch secondCDL=new CountDownLatch(1);
    CountDownLatch thirdCDL=new CountDownLatch(1);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondCDL.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondCDL.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdCDL.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdCDL.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] nums = {3,2,2};
        Foo foo = new Foo();
        new Thread(()->{
            try {
                foo.first(()-> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(()-> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(()-> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
