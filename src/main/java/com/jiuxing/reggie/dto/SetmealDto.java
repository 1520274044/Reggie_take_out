package com.jiuxing.reggie.dto;

import com.jiuxing.reggie.entity.Setmeal;
import com.jiuxing.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/8  17:02
 */
@Data
public class SetmealDto extends Setmeal {
    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
