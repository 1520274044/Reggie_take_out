package com.jiuxing.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuxing.reggie.dto.SetmealDto;
import com.jiuxing.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  19:24
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时保持套餐和菜品的保存关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐 同时删除套餐关联的菜品
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
