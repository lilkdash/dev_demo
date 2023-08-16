package com.kzheng.thread;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/4 12:17
 */

public class Case1 {
    /*1.有二十个账户。每个账户初始余额10000元。
      2.有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
      3.每个线程执行100次转账操作，需要考虑类似数据库操作和激情并非执行
      4.最后请打印出二十个账户的余额
    */
    AtomicInteger  balance=new AtomicInteger(10000);
    public int addAndGet(int delta){
        return balance.addAndGet(delta);
    }
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        List<Case1> account=new ArrayList(20);
        for (int i = 0; i < 20; i++) {
            account.add(new Case1());
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始执行任务");
                for (int j = 0; j < 100; j++) {
                    int b1=new Random().nextInt(20);
                    int b2=new Random().nextInt(20);
                    while(b1==b2){
                        b2=new Random().nextInt(20);
                    }
                    Case1 income=account.get(b1);
                    Case1 outcome=account.get(b2);
                    int amount=new Random().nextInt(100)+1;
                    income.addAndGet(amount);
                    outcome.addAndGet(-amount);
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count=0;
        for (int i = 0; i < account.size(); i++) {
            AtomicInteger atomicInteger = account.get(i).balance;
            System.out.println("第"+(i+1)+"个账户金额为："+ account.get(i).balance);
            count=atomicInteger.addAndGet(count);
        }
        System.out.println();
        System.out.println("20个账户总金额为："+count);
    }

}
