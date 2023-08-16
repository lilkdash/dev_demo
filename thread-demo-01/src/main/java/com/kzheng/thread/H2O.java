package com.kzheng.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/12 13:06
 */
public class H2O {

    Semaphore shh=new Semaphore(2);
    Semaphore sho=new Semaphore(1);
    CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        shh.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        shh.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        sho.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        sho.release();
    }
    public static void main(String[] args) throws InterruptedException {
        String str="OOHHHHHOH";
        H2O h2o = new H2O();
        for (int i = 0; i < str.length(); i++) {
            int index=i;
            new Thread(()->{
                if('H'==str.charAt(index)){
                    try {
                        h2o.hydrogen(()-> System.out.print("H"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if('O'==str.charAt(index)){
                    try {
                        h2o.oxygen(()-> System.out.print("O"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
