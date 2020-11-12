package com.ssm.controller.rest;

import com.ssm.domain.User;
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

    @PostMapping("/create")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/find")
    public User findUserByName(@RequestParam(name = "name") String name) {
        return userService.findUserByName(name);
    }
}
