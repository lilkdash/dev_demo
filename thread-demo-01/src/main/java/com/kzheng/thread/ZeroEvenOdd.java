package com.kzheng.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/10 14:58
 */
class ZeroEvenOdd {
    private int n;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n;i++) {
            System.out.println("当前线程"+Thread.currentThread()+"获取许可前z："+z.availablePermits());
            z.acquire();
            System.out.println("当前线程"+Thread.currentThread()+"获取许可后z："+z.availablePermits());
            printNumber.accept(0);
            System.out.println();
            boolean flag=((i&1)==0);
            System.out.println("(i&1)==0:"+flag);
            if((i&1)==0) {
                System.out.println("当前线程"+Thread.currentThread()+"释放许可前o："+o.availablePermits());
                o.release();
                System.out.println("当前线程"+Thread.currentThread()+"释放许可后o："+o.availablePermits());
            }else {
                System.out.println("当前线程"+Thread.currentThread()+"释放许可前e："+e.availablePermits());
                e.release();
                System.out.println("当前线程"+Thread.currentThread()+"释放许可后e："+e.availablePermits());
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            System.out.println("当前线程"+Thread.currentThread()+"获取许可前e："+e.availablePermits());
            e.acquire();
            System.out.println("当前线程"+Thread.currentThread()+"获取许可后e："+e.availablePermits());
            printNumber.accept(i);
            System.out.println();

            System.out.println("当前线程"+Thread.currentThread()+"释放许可前z："+z.availablePermits());
            z.release();
            System.out.println("当前线程"+Thread.currentThread()+"释放许可后z："+z.availablePermits());
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            System.out.println("当前线程"+Thread.currentThread()+"获取许可前o："+o.availablePermits());
            o.acquire();
            System.out.println("当前线程"+Thread.currentThread()+"获取许可后o："+o.availablePermits());
            printNumber.accept(i);
            System.out.println();

            System.out.println("当前线程"+Thread.currentThread()+"释放许可前z："+z.availablePermits());
            z.release();
            System.out.println("当前线程"+Thread.currentThread()+"释放许可后z："+z.availablePermits());
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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
        /*IntConsumer display = a -> System.out.println(a * 100);
        IntConsumer mul = a -> System.out.println(a * 5);

        // Using andThen() method
        IntConsumer composite = mul.andThen(display);
        composite.accept(3);*/
    }
}
