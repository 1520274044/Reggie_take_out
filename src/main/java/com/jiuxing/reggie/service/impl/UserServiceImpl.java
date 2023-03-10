package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.entity.User;
import com.jiuxing.reggie.mapper.UserMapper;
import com.jiuxing.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/8  22:03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements UserService {
}
