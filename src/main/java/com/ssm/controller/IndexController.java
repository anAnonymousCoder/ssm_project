package com.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 跳转Controller
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
@Controller
public class IndexController {

    /**
     * 跳转到user-manage.html
     *
     * @return 目标html
     */
    @GetMapping("/user/user-manage")
    public String userManage() {
        return "user-manage";
    }
}
