package com.ssm.service.Impl;

import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.domain.dto.ResultDto;
import com.ssm.service.UserService;
import com.ssm.util.EncryptUtil;
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

    /**
     * 新建用户
     *
     * @param user 用户实体
     * @return 插入记录数
     */
    public ResultDto<User> createUser(User user) {
        User savedUser = userDao.findUserByName(user.getName());
        if (savedUser == null) {
            String password = user.getPassword();
            //对原始输入密码进行md5加密
            user.setPassword(EncryptUtil.encrypt(password));
            try {
                userDao.createUser(user);
                return new ResultDto<>(ResultDto.ResultCode.SUCCESS.getCode(), "insert-success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResultDto<>(ResultDto.ResultCode.FAILURE.getCode(), "insert-error");
            }
        } else {
            return new ResultDto<>(ResultDto.ResultCode.WARNING.getCode(), "already-exists");
        }
    }

    /**
     * 用户登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 查找结果
     */
    @Override
    public ResultDto<User> checkLogin(String name, String password) {
        User user = userDao.findUserByName(name);
        if (user == null) {
            return new ResultDto<>(ResultDto.ResultCode.WARNING.getCode(), "user-not-found");
        }
        String userPassword = user.getPassword();
        if (EncryptUtil.equals(password, userPassword)) {
            return new ResultDto<>(ResultDto.ResultCode.SUCCESS.getCode(), "success");
        } else {
            return new ResultDto<>(ResultDto.ResultCode.FAILURE.getCode(), "password-error");
        }
    }
}
