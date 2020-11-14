package com.ssm.controller.rest;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.dto.ResultDto;
import com.ssm.domain.dto.UserDto;
import com.ssm.service.UserService;
import com.ssm.vo.PageVO;
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
     * @param userDto User数据传输对象
     * @return 插入记录数
     */
    @PostMapping("/create")
    public ResultDto<UserDto> createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 登录结果
     */
    @GetMapping("/login")
    public ResultDto<UserDto> login(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "password") String password) {
        return userService.checkLogin(name, password);
    }

    @GetMapping("/page")
    public PageVO<UserDto> page(@RequestParam(name = "page") int page,
                                @RequestParam(name = "limit") int limit) {
        PageInfo<UserDto> pageInfo = userService.page(page, limit);
        return new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
