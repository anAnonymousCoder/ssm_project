package com.ssm.service;

import com.ssm.domain.User;
import com.ssm.domain.dto.ResultDto;

/**
 * User服务接口
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public interface UserService {

    //新建用户
    ResultDto<User> createUser(User user);

    //用户登录验证
    ResultDto<User> checkLogin(String name, String password);
}
