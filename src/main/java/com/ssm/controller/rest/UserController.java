package com.ssm.controller.rest;

import com.ssm.domain.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
