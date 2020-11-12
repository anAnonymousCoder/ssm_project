package com.ssm.service;

import com.ssm.domain.User;

/**
 * User服务接口
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public interface UserService {

    int createUser(User user);

    User findUserByName(String name);
}
