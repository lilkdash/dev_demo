package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
}
