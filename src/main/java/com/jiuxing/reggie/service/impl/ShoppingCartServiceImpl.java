package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.entity.ShoppingCart;
import com.jiuxing.reggie.mapper.ShoppingCartMapper;
import com.jiuxing.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/9  18:40
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper , ShoppingCart> implements ShoppingCartService {
}
