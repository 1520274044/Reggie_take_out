package com.jiuxing.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuxing.reggie.entity.Category;


/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  17:32
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
