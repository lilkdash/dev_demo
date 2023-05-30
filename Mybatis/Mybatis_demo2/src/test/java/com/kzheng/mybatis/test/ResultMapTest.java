package com.kzheng.mybatis.test;

import com.kzheng.mybatis.mapper.DeptMapper;
import com.kzheng.mybatis.mapper.EmpMapper;
import com.kzheng.mybatis.pojo.Dept;
import com.kzheng.mybatis.pojo.Emp;
import com.kzheng.mybatis.utils.SqlsessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 字段名和属性名不一致的问题：
     * 方式一：sql中每个字段设置别名
     * 方式二：mabtais全局配置settings.mapUnderscoreToCamelCase为true
     * 方式三：resultMap 自定义映射
     */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        List<Emp> list=mapper.getAllEmp();
        list.forEach(emp->System.out.println(emp));

    }
    @Test
    public void testGetAllEmpAndDept(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        List<Emp> list=mapper.getAllEmpAndDept();
        /* list.forEach(emp->System.out.println(emp));*/
        /**
         * 分布查询的优点：延迟加载，但是必须在核心配置文件中设置全局配置信息
         */
        list.forEach(emp->System.out.println(emp.getEmpName()));
    }
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession= SqlsessionUtils.getSqlSession();
        DeptMapper mapper=sqlSession.getMapper(DeptMapper.class);
        List<Dept> list=mapper.getDeptAndEmp(1);
        /* list.forEach(emp->System.out.println(emp));*/
        /**
         * 分布查询的优点：延迟加载，但是必须在核心配置文件中设置全局配置信息
         */
        list.forEach(dept->System.out.println(dept));
    }
}
