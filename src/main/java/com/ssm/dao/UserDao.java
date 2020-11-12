package com.ssm.dao;

import com.ssm.domain.User;

/**
 * User DAO
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public interface UserDao {

    int createUser(User user);

    User findUserByName(String name);
}
