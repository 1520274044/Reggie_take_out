package com.jiuxing.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/3  22:42
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class reggieApplication {
    public static void main(String[] args) {
        /**
         * 测试pull到远程仓库
         */
        log.info("123");
        SpringApplication.run(reggieApplication.class,args);
        log.info("项目启动成功~~~");
    }
}
