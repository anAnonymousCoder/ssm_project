package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.dto.ResultDto;
import com.ssm.domain.dto.UserDto;

/**
 * User服务接口
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public interface UserService {

    //新建用户
    ResultDto<UserDto> createUser(UserDto userDto);

    //用户登录验证
    ResultDto<UserDto> checkLogin(String name, String password);

    //分页查询
    PageInfo<UserDto> page(int page, int limit);
}
