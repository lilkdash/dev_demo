package com.kzheng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/5/12 15:11
 */
@Component
public class MyLB implements LoadBalancer {
    private  AtomicInteger atomicInteger=new AtomicInteger(0);
    //获取接口访问次数
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=2147483647 ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***第几次访问，次数next:"+next);
        return next;
    }
    //根据算法获取对应服务实例
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement() % serviceInstances.size();
        return  serviceInstances.get(index);
    }

}
