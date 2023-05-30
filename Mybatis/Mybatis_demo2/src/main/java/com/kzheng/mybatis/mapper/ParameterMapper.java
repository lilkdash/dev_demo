package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * 查询所有用户有
     */
    List<User> getAllUser();
    User getUserByUserName(String username);
    User checkLogin(String username,String password);
    User checkLoginByParam(@Param("username")String username,@Param("password") String password);
    Map<String,Object> getUserByIdToMap(@Param("id")int id);
    List<User> getAllUserByUserByLike(@Param("username") String username);
    int deleteMore(@Param("ids") String ids);
    int deleteMoreByName(@Param("usernames") String usernames);
    void insertUser(User user);
}
