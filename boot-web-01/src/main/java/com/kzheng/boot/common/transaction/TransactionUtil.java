package com.kzheng.boot.common.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.function.Consumer;

/**
 * @Author kaizheng
 * @Description 事务管理工具
 * @Date 2023/7/31 15:50
 */
@Component
@Slf4j
public class TransactionUtil {
    @Autowired
    private PlatformTransactionManager transactionManager;

    public boolean transact(Consumer consumer) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        log.info("=======事务开始=======");
        try {
            consumer.accept(null);

            transactionManager.commit(status);
            log.info("=======事务提交=======");
            return true;
        } catch (Exception e) {
            transactionManager.rollback(status);
            log.info("=======事务回滚=======");
            e.printStackTrace();
            return false;
        }
    }
}
