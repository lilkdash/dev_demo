package com.kzheng.boot.dao;

import com.kzheng.boot.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/27 23:03
 */
@Mapper
@Repository
public interface TUserDao {
    /**
     * mybatis 面向接口编程
     * 1.映射文件的namespace要和mapper接口的全类名保持一致
     * 2.映射文件中SQL语句的ID要和mapper接口中的方法名一致
     * 表--实体类-mapper接口--映射文件
     */

    /**
     * 新增用户
     * @return
     */
    int inertUser();

    /**
     * 修改用户
     */
    void updateUser();
    /**
     * 删除用户
     */
    int deleteUser();
    /**
     * 根据D查询用户
     */
    TUser getUserById(@Param("id") int id);
    /**
     * 根据userId查询用户
     */
    TUser getUserByUserId(@Param("userId") String userId);
    /**
     * 查询所有用户有
     */
    List<TUser> getAllUser();
    /**
     * 登陆验证
     */
    TUser login(@Param("userId") String userId,@Param("password") String password);
}
