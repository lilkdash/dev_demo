package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
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
    User getUserById();
    /**
     * 查询所有用户有
     */
    List<User> getAllUser();

}
