package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> getAllEmp();
    List<Emp> getAllEmpAndDept();
}
