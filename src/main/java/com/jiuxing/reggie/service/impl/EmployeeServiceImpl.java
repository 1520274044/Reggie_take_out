package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.entity.Employee;
import com.jiuxing.reggie.mapper.EmployeeMapper;
import com.jiuxing.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/3  23:18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl <EmployeeMapper, Employee> implements EmployeeService {
}
