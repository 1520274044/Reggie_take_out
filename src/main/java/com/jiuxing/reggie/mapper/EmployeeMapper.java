package com.jiuxing.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiuxing.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/3  23:15
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
