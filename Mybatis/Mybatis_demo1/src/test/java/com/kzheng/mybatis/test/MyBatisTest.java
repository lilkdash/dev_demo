package com.kzheng.mybatis.test;

import com.kzheng.mybatis.mapper.UserMapper;
import com.kzheng.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result=mapper.inertUser();
        sqlSession.commit();
        System.out.println(result);
    }
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.commit();
    }
    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result=mapper.deleteUser();
        sqlSession.commit();
        System.out.println(result);
    }
    @Test
    public void testGetUserById() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById();
        System.out.println(user);
    }
    @Test
    public void testGetAllUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users=mapper.getAllUser();
        users.forEach(user->System.out.println(user));
    }
}
