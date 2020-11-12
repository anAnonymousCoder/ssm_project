package com.ssm.service.Impl;

import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User服务接口实现类
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User findUserByName(String name) {
        User user = userDao.findUserByName(name);
        if (user == null) {
            return new User();
        }
        return user;
    }
}
