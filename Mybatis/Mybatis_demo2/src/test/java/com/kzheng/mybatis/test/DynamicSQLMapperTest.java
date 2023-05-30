package com.kzheng.mybatis.test;

import com.kzheng.mybatis.mapper.DeptMapper;
import com.kzheng.mybatis.mapper.DynamicSQLMapper;
import com.kzheng.mybatis.mapper.EmpMapper;
import com.kzheng.mybatis.pojo.Dept;
import com.kzheng.mybatis.pojo.Emp;
import com.kzheng.mybatis.utils.SqlsessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new  Emp(null,"张三",213, null,null, null);
        List<Emp> list=mapper.getEmpByCondition(emp);
        list.forEach(obj->System.out.println(obj));
    }
    @Test
    public void testUpdateBatch(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new  Emp(null,"张三",213, null,null, null);
        int result=mapper.updateAgeBatch(new Integer[]{1,2,3});
        sqlSession.commit();
        System.out.println(result);
    }
    @Test
    public void testInsertBatch(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new  Emp(null,"张三2",213, null,null, null);
        Emp emp2 =new  Emp(null,"张三3",213, null,null, null);
        Emp emp3 = new  Emp(null,"张三4",213, null,null, null);
        List<Emp> emps = Arrays.asList(emp, emp2, emp3);
        int result=mapper.insertEmpBatch(emps);
        sqlSession.commit();
        System.out.println(result);
    }
}
