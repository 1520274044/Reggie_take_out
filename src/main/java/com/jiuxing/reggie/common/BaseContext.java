package com.jiuxing.reggie.common;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/6  17:06
 */

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户的id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    /**
     * 设置值id
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取值 id
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
