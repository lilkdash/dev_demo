package com.kzheng.mybatis.test;

import com.kzheng.mybatis.mapper.CacheMapper;
import com.kzheng.mybatis.mapper.ParameterMapper;
import com.kzheng.mybatis.pojo.Emp;
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

/**
 * mybatis缓存查询顺序
 * 先查二级缓存，因为二级缓存中可能有其他程序中已经查出来的数据，可以拿来直接用
 * 如果二级缓存没有命中，再查询一级缓存
 * 如果一级缓存也没有命中，查询数据库
 * sqlsession关闭之后，一级缓存中的数据会导入二级缓存
 */
public class CacheMapperTest {
    /**
     * 一级缓存默认开启，级别sqlsession;第二次从缓存中获取数据
     * 一级缓存失效的四种情况
     * 1.不同的sqlsession对应不同的一级缓存
     * 2.同一个sqlsession但是查询条件不同
     * 3。同一个sqlsession单数查询期间执行了任何一次增删改操作
     * 4.同一个sqlsession两次查询期间手动清空了缓存sqlSession.clearCache();//手动清空缓存
     */
    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlsessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp=mapper.getEmpByEid(1);
        System.out.println(emp);

        //sqlSession.clearCache();//手动清空缓存
        Emp emp2=mapper.getEmpByEid(1);
        System.out.println(emp2);
        SqlSession sqlSession2 = SqlsessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3=mapper2.getEmpByEid(1);
        System.out.println(emp3);
    }
    /**
     * 二级缓存开启条件(SqlSessionFactory级别)：
     * 1.核心配置文件中设置cacheEnabled="true"(默认是true)
     * 2.在映射文件中设置标签<cache/>
     * 3.必须在sqlsession关闭或提交之后才生效
     * 4.查询的数据所转换的实体类型必须实现序列化接口
     * 二级缓存失效的情况：
     * 1.两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */
    @Test
    public void testTwoCache(){
        SqlSession sqlSession=null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSession = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp=mapper.getEmpByEid(1);
            System.out.println(emp);
            sqlSession.close();
            SqlSession sqlSession2 = sessionFactory.openSession();//sessionFactory.openSession(true)表示自动提交事务
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2=mapper2.getEmpByEid(1);
            System.out.println(emp2);
            //sqlSession2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
