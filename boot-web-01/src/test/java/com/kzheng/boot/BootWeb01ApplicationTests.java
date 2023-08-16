package com.kzheng.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.IntBinaryOperator;

@Slf4j
@SpringBootTest
class BootWeb01ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    StringRedisTemplate redisTemplate;
    @Test
    void contextLoads() {

//        jdbcTemplate.queryForObject("select * from account_tbl")
//        jdbcTemplate.queryForList("select * from account_tbl",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型：{}",dataSource.getClass());
    }
    @Test
    public void testRedis2(){
       // Boolean result=redisTemplate.opsForValue().setIfAbsent(lockKey, "xiaoyan");
    }
    @Test
    public void testRedis(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("hello","world");
//        System.out.println(valueOperations.get("hello"));
//        System.out.println("结束");
        String s1="123";
        String s2=new String ("123");
        Integer t1=1;
        Integer t2=1;
        System.out.println(s1==s2);
        System.out.println(s1=="123");
        System.out.println(s2=="123");
        System.out.println(t1==t2);
        int s=1/0;
    }
    ReentrantLock lock = new ReentrantLock(true);
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    class Task implements Runnable {

        private String phone;

        public Task(String phone) {
            this.phone = phone;
        }
        @Override
        public void run() {
            lock.lock();
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // 先查看手机是否存在 存在的话就阻断  不存在的话就执行下面的逻辑
                String value = map.get(phone);
                if (StringUtils.isEmpty(value)) {
                    map.put(phone, phone);
                    System.out.println("线程名称：" + Thread.currentThread().getName() + " " + "手机号: " + phone + " 已发送短信");
                } else {
                    System.out.println("线程名称：" + Thread.currentThread().getName() + " " + "手机号：" + phone + " 请勿重复发送");
                }
            } finally {
                lock.unlock();
            }
        }
    }
    @Test
    public void testThread(){

        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            threadPool.submit(new Task("18321682662"));
        }
        threadPool.shutdownNow();
    }
    @Test
    public void testLambda(){
        /**
         * 方法参数是接口
         * 参数类型可被推导
         * lamdba不关注类名方法名，关注方法中的参数
         * 方法只有一句代码时，大括号和分号可以省略
         * 参数类型可以省略，如果只有一个参数，（）也可以省略
         */
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中的方法被执行了");
            }
        }).start();*/
        new Thread(()-> {System.out.println("新线程中的方法被执行了");}).start();
        //方法只有一句代码时，大括号和分号可以省略
        new Thread(()-> System.out.println("新线程中的方法被执行了")).start();
        int i=calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        int i3=calculateNum((left, right) -> left+right);
        System.out.println(i);
        int i2=calculateNum(( left,  right)-> { return left+right; });
        System.out.println(i2);
    }
    public int calculateNum(IntBinaryOperator operator){
        int a=10,b=20;
        return operator.applyAsInt(a,b);
    }
}
