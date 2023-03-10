package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.common.CustomException;
import com.jiuxing.reggie.dto.SetmealDto;
import com.jiuxing.reggie.entity.Setmeal;
import com.jiuxing.reggie.entity.SetmealDish;
import com.jiuxing.reggie.mapper.SetmealMapper;
import com.jiuxing.reggie.service.SetmealDishService;
import com.jiuxing.reggie.service.SetmealService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  19:24
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper , Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐，同时保持套餐和菜品的保存关系
     *
     * @param setmealDto
     */
    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();

        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());
        //保存套餐和菜品的关联信息
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐 同时删除套餐关联的菜品
     *
     * @param ids
     */
    @Override
    @Transactional
    public void removeWithDish(List<Long> ids) {
        //查询套餐的状态确定是否删除
        LambdaQueryWrapper<Setmeal> queryWrapper=new LambdaQueryWrapper<>();

        queryWrapper.in(Setmeal::getId , ids);
        queryWrapper.eq(Setmeal::getStatus , 1);

        int count = this.count();

        if(count>0){
            //如果不能删除，抛出一个业务异常
            throw new CustomException("套餐正在售卖中，不能删除");
        }

        //如果可以删除先删除套餐表中的数据
        this.removeByIds(ids);

        //删除关联表表中的数据
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId , ids);

        setmealDishService.remove(lambdaQueryWrapper);
    }
}
