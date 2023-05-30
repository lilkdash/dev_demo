package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    Dept getEmpAndDeptBySteptTwo();
    /**
     * 查询部门及部门中所有员工对象
     */
    List<Dept> getDeptAndEmp(@Param("did") Integer did);
}
