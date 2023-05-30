package com.kzheng.mybatis.test;

import com.kzheng.mybatis.mapper.ParameterMapper;
import com.kzheng.mybatis.pojo.User;
import com.kzheng.mybatis.utils.SqlsessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    /**
     * ${}本质是字符串拼接，存在sql注入风险，需要拼接单引号
     * #{}本质上是占位符，按位置传值即可
     */
    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users=mapper.getAllUser();
        users.forEach(user->System.out.println(user));
    }
    @Test
    public void TestGetUserByUserName() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.getUserByUserName("张三");
        System.out.println(user);
    }
    @Test
    public void TestCheckLogin() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLogin("张三","123456");
        System.out.println(user);
    }
    @Test
    public void TestCheckLoginByParam() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLoginByParam("张三","123456");
        System.out.println(user);
    }
    @Test
    public void TestGetUserByIdToMap() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=mapper.getUserByIdToMap(3);
        System.out.println(map);
    }
    @Test
    public void TestGetAllUserByUserByLike() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users=mapper.getAllUserByUserByLike("三");
        users.forEach(user->System.out.println(user));
    }
    @Test
    public void TestDeleteMore() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        // System.out.println(mapper.deleteMore("1,2,3"));
        System.out.println(mapper.deleteMoreByName("张三,李四"));
    }
    @Test
    public void TestInsertUserResultKey() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=new User(null,"李四","123123",12,"女","18258@163.com");
        mapper.insertUser(user);
        sqlSession.commit();
        System.out.println(user);
    }
}
