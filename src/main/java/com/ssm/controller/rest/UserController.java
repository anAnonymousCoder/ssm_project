package com.ssm.controller.rest;

import com.ssm.domain.User;
import com.ssm.domain.dto.ResultDto;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ResponseBody + Controller，RESTful风格的Controller
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
@RequestMapping("/rest/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 新建用户
     *
     * @param user 用户实体
     * @return 插入记录数
     */
    @PostMapping("/create")
    public ResultDto<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 登录结果
     */
    @GetMapping("/login")
    public ResultDto<User> login(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "password") String password) {
        return userService.checkLogin(name, password);
    }
}
