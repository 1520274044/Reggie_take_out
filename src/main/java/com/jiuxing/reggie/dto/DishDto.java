package com.jiuxing.reggie.dto;

import com.jiuxing.reggie.entity.Dish;
import com.jiuxing.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/7  13:43
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors=new ArrayList<>();

    private String categoryName;

    private Integer copies;

}
