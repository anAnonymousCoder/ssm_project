package com.ssm.dao;

import com.ssm.domain.User;

import java.util.List;

/**
 * User DAO
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public interface UserDao {

    //新建用户
    int createUser(User user);

    //通过name查找用户
    User findUserByName(String name);

    //查找全部用户
    List<User> findAll();
}
