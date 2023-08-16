package com.kzheng.boot.service;

import com.kzheng.boot.dao.TUserDao;
import com.kzheng.boot.entity.TUser;
import com.kzheng.boot.common.secure.JwtTokenUtils;
import com.kzheng.boot.common.transaction.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/27 23:05
 */
@Service
@Slf4j
public class TUserService implements ITUserService{
    /**
     * 使用@Autowired的当前类也必须由spring容器托管（打@Coponent、@Controller、@Service 、@repository），默认按照类型匹配
     * @Resource是J2EE的注解，默认按照名称匹配
     */
    @Autowired
    private TUserDao tUserDao;

    @Override
    public int inertUser() {
        return 0;
    }

    @Override
    public void updateUser() {

    }

    @Override
    public int deleteUser() {
        return 0;
    }

    @Override
    public TUser getUserById(@Param("id") int id) {
        return tUserDao.getUserById(id);
    }
    @Autowired
    private TransactionUtil transactionUtil;

    /**
     * TransactionManager的使用
     * @param id
     * @return
     */
    public boolean getUserById2(@Param("id") int id) {
/*        Consumer consumer= o -> {
            TUser tuser=tUserDao.getUserById(id);
            if(tuser!=null){
                log.info("查询结果:  "+tuser.toString());
            }else{
                log.info("查询结果为空 ");
            }
        };*/
        return transactionUtil.transact(o -> {
            TUser tuser=tUserDao.getUserById(id);
            if(tuser!=null){
                log.info("查询结果:  "+tuser.toString());
            }else{
                log.info("查询结果为空 ");
            }
        });
    }
    @Override
    public TUser getUserByUserId(@Param("userId") String userId) {
        return tUserDao.getUserByUserId(userId);
    }
    @Override
    public List<TUser> getAllUser() {
        return null;
    }
    /**
     * 登陆验证
     */
    @Override
    public TUser login(@Param("userId") String userId,@Param("password") String password){
        TUser tuser=tUserDao.login(userId,password);
        Optional.ofNullable(tuser).ifPresent(u->{
            //添加token信息设置到用户实体上
            String token = JwtTokenUtils.getToken(tuser.getUserId(),password);
            log.info("token的值为：{}",token);
            tuser.setToken(token);
        });
        return tuser;
    }
}
