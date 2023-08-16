package com.kzheng.thread;

import java.util.concurrent.*;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/6/7 15:00
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        int corePoolSize=3, maximumPoolSize=5;
        long keepAliveTime=10;
        TimeUnit unit=TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        ThreadFactory threadFactory = new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                return thread;
            }
        };
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,//核心线程数
                maximumPoolSize,// 最大线程数
                keepAliveTime,//非核心线程存活时间
                unit,//非核心线程存活时间的单位
                workQueue,//阻塞、工作队列
                threadFactory,//线程工厂
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("My rejectExecution");
                    }
                });//拒绝策略
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            /*threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +"任务：" + finalI
                            +"----"
                            +threadPoolExecutor.getActiveCount()
                            +"----"
                            +threadPoolExecutor.getLargestPoolSize()
                            +"------"
                            + threadPoolExecutor.getPoolSize()
                            +"------"
                            + threadPoolExecutor.getCompletedTaskCount()
                            + "------"
                            +threadPoolExecutor.getQueue());
                }
            });*/
        }

    }
}
