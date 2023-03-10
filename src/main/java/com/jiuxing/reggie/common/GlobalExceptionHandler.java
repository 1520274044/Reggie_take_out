package com.jiuxing.reggie.common;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/5  22:16
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exception(SQLIntegrityConstraintViolationException ex){
        log.info(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg=split[2]+"已存在";
            return R.error(msg);
        }
        return R.error("未知错误");
    }


    /**
     * 业务层异常处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exception(CustomException ex){
        log.info(ex.getMessage());
        return R.error(ex.getMessage());
    }
}