package com.kzheng.thread;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {
    @Test
    public void threadTest1() {
        Object o = new Object();
        //打印对象的内存布局信息
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //执行代码的时候锁住对象o
        //对象的锁是加在markword上的
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
    @Test
    public void threadToolTest(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,//核心线程数
                2,// 最大线程数
                500,//非核心线程存活时间
                TimeUnit.SECONDS,//非核心线程存活时间的单位
                new LinkedBlockingQueue<Runnable>(),//阻塞、工作队列
                new ThreadFactory() {//线程工厂
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t=new Thread(r);
                        t.setName("测试一");
                        return t;
                    }
                },new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("嘿嘿嘿嘿");
            }
        });
        //submit 可以返回结果
        Future<Object> future=threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call()throws Exception{
                System.out.println("xxxxx");
                return "xx";
            }
        });

    }
    @Test
    public void otherTest(){
       /* List list = new ArrayList<>();
        list.add(1);
        list.add(true);
        list.add("123");
        for (int i = 0; i < list.size(); i++) {
            Object next = list.get(i);
            *//**
             * 输出java.lang.Integer cannot be cast to java.lang.String
             * 存在类型转换异常
             *//*
            System.out.println((String)next);
        }*/
        //使用泛型,指定类型
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("123");
        for (int i = 0; i < list2.size(); i++) {
            String o = list2.get(i);
            System.out.println(o);
        }
        Executors.newFixedThreadPool(1);
    }
}
