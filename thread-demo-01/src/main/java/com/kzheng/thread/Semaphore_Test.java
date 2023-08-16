package com.kzheng.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/6 23:38
 */
public class Semaphore_Test {
    private int n;
    public Semaphore_Test(int n) {
        this.n = n;
    }
    ReentrantLock lock=new ReentrantLock();
    Semaphore o = new Semaphore(1);
    Semaphore e = new Semaphore(0);


    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for(int i=2; i<=n; i+=2) {
            System.out.println("当前线程"+Thread.currentThread()+"获取许可前e："+e.availablePermits());
            e.acquire();
            System.out.println("当前线程"+Thread.currentThread()+"获取许可后e："+e.availablePermits());
            printNumber.accept(i);
            System.out.println();

            System.out.println("当前线程"+Thread.currentThread()+"释放许可前z："+o.availablePermits());
            o.release();
            System.out.println("当前线程"+Thread.currentThread()+"释放许可后z："+o.availablePermits());
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            System.out.println("当前线程"+Thread.currentThread()+"获取许可前o："+o.availablePermits());
            o.acquire();
            System.out.println("当前线程"+Thread.currentThread()+"获取许可后o："+o.availablePermits());
            printNumber.accept(i);
            System.out.println();

            System.out.println("当前线程"+Thread.currentThread()+"释放许可前z："+e.availablePermits());
            e.release();
            System.out.println("当前线程"+Thread.currentThread()+"释放许可后z："+e.availablePermits());
        }
    }

    public static void main(String[] args) {
        Semaphore_Test zeroEvenOdd = new Semaphore_Test(5);

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
