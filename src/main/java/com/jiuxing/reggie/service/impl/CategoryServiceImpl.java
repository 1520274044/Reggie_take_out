package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.common.CustomException;
import com.jiuxing.reggie.entity.Category;
import com.jiuxing.reggie.entity.Dish;
import com.jiuxing.reggie.entity.Setmeal;
import com.jiuxing.reggie.mapper.CategoryMapper;
import com.jiuxing.reggie.service.CategoryService;
import com.jiuxing.reggie.service.DishService;
import com.jiuxing.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  17:33
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper , Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;
    /**
     * 根据id删除分类 ，删除之前进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper();
        //添加查询条件，根据分类id进行删除
        queryWrapper.eq(Dish::getCategoryId ,id);
        int count1 = dishService.count();
        if(count1>0){
            //查询当前分类是否关联了菜品，如果已经关联，抛出业务层异常
            throw new CustomException("当前分类下关联了菜品，不能删除！");
        }


        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId , id);

        int count2 =setmealService.count();
        if(count2>0){
            //查询当前分类是否关联了套餐，如果已经关联，抛出业务层异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        //正常删除分类
        super.removeById(id);

    }
}
