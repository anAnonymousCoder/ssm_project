package com.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.UserDao;
import com.ssm.domain.User;
import com.ssm.domain.builder.UserBuilder;
import com.ssm.domain.dto.ResultDto;
import com.ssm.domain.dto.UserDto;
import com.ssm.service.UserService;
import com.ssm.util.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User服务接口实现类
 *
 * @author wqy
 * @version 1.0 2020/11/15
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //Slf4j
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 新建用户
     *
     * @param userDto 用户数据传输类
     * @return 插入记录数
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultDto<UserDto> createUser(UserDto userDto) {
        User savedUser = userDao.findUserByName(userDto.getName());
        if (savedUser == null) {
            try {
                userDao.createUser(UserBuilder.buildEntity(userDto));
                return new ResultDto<>(ResultDto.ResultCode.SUCCESS.getCode(), "insert-success");
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage());
                return new ResultDto<>(ResultDto.ResultCode.FAILURE.getCode(), "insert-error");
            }
        } else {
            logger.warn("user already exists");
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
    public ResultDto<UserDto> checkLogin(String name, String password) {
        User user = userDao.findUserByName(name);
        if (user == null) {
            logger.warn("user not found");
            return new ResultDto<>(ResultDto.ResultCode.WARNING.getCode(), "user-not-found");
        }
        if (EncryptionUtil.equals(password, user.getPassword())) {
            return new ResultDto<>(ResultDto.ResultCode.SUCCESS.getCode(), "success");
        } else {
            logger.warn("password mismatch");
            return new ResultDto<>(ResultDto.ResultCode.FAILURE.getCode(), "password-error");
        }
    }

    /**
     * 分页查询
     *
     * @param page  当前页码
     * @param limit 每页记录数
     * @return PageInfo
     */
    @Override
    public PageInfo<UserDto> page(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<User> userList = userDao.findAll();
        return new PageInfo<>(UserBuilder.buildDtoList(userList));
    }
}
