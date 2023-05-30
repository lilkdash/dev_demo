package com.kzheng.mybatis.mapper;

import com.kzheng.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 批量修改年龄
     * @param eids
     */
    int updateAgeBatch(@Param("eids") Integer[] eids);

    /**
     * 批量新增
     * @param emps
     * @return
     */
    int insertEmpBatch(@Param("emps") List<Emp> emps);
}
