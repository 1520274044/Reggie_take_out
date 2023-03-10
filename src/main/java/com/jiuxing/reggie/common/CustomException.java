package com.jiuxing.reggie.common;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  19:51
 */

/**
 * 自定义业务层异常类
 */
public class CustomException extends  RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
