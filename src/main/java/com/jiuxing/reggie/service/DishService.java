package com.jiuxing.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuxing.reggie.dto.DishDto;
import com.jiuxing.reggie.entity.Dish;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  19:22
 */

public interface DishService extends IService<Dish> {
    //新增菜品对应的口味菜品，需要操作dish dish_flavor两张表
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新对应的口味信息
    public void updateWithFlavor(DishDto dishDto);
}
