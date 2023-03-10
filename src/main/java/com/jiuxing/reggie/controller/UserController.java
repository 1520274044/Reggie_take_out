package com.jiuxing.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiuxing.reggie.common.R;
import com.jiuxing.reggie.entity.User;
import com.jiuxing.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/8  22:04
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 手机发送验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user , HttpSession session ){
        //获取手机号码
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            return R.success("短信发送成功");
        }
        return R.error("短信发送失败");
    }

    /**
     * 移动端登录功能
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map , HttpSession session){
        //获取手机号
        String phone = map.get("phone").toString();

        //获取验证码

        //从session中获取保存的验证码
        //进行验证码对比
        //如果能够比对成功，说明登录成功

        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone , phone);
        User user = userService.getOne(queryWrapper);
        if(user==null){
            //判断当前手机号对应的用户是否为新用户 ，如果是就自动完成注册
            user=new User();
            user.setPhone(phone);
            user.setStatus(1);
            userService.save(user);
        }
        return R.success(user);
    }
}
