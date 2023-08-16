package com.kzheng.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/4 20:03
 */
public class ThreadLocal_Case_SDF {
    /**
     * 1.SimpleDateFormat因为内部使用了日历对象Calendar，导致不能将其作为线程共享对象，会引发线程安全问题。
     * 因为只有一个Calendar实例，而多线程共享该实例
     * 2.ThreadLocal底层是ThreadLocal.ThreadLocalMap threadLocals = null;来存储，key是当前ThreadLocal，value是存储值
     * 可以存储多个ThreadLocal
     * 3.ThreadLocal.ThreadLocalMap底层的Entry extends WeakReference<ThreadLocal<?>>内部类是弱引用，gc时会被回收，所以map的key会被回收，但是value依然存在
     * 所以会出现oom内存溢出的问题，用完后需要手动remove
     */
    //private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static final ThreadLocal<SimpleDateFormat> context=ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
    private static final ThreadLocal<String> context2=new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            Date date=new Date(1665384660000L);
            System.out.println(Thread.currentThread().getName()+":"+context.get().format(date));
            context2.set("A");
            context2.remove();
            System.out.println(context2.get());
        }).start();
        new Thread(()->{
            Date date=new Date(1665471060000L);
            System.out.println(Thread.currentThread().getName()+":"+context.get().format(date));
            context2.set("B");
            System.out.println(context2.get());
        }).start();
        new Thread(()->{
            Date date=new Date(1665557460000L);
            System.out.println(Thread.currentThread().getName()+":"+context.get().format(date));
            context2.set("C");
            System.out.println(context2.get());
        }).start();
    }
}
