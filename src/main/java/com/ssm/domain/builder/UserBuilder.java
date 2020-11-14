package com.ssm.domain.builder;

import com.ssm.domain.User;
import com.ssm.domain.dto.UserDto;
import com.ssm.util.EncryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User和UserDto转换类
 *
 * @author wqy
 * @version 1.0 2020/11/14
 */
public class UserBuilder {

    private UserBuilder() {

    }

    /**
     * 将user的属性拷贝给userDto
     *
     * @param user    User实体
     * @param userDto UserDto
     */
    private static void toDto(User user, UserDto userDto) {
        if (user != null && userDto != null) {
            //忽略密码，前端不能取到用户的密码
            BeanUtils.copyProperties(user, userDto, "password");
        }
    }

    /**
     * 返回拷贝属性后的userDto
     *
     * @param user User实体
     * @return UserDto
     */
    public static UserDto buildDto(User user) {
        if (user != null) {
            UserDto userDto = new UserDto();
            toDto(user, userDto);
            return userDto;
        }
        return null;
    }

    /**
     * 返回拷贝属性后的userDto列表
     *
     * @param userList User实体列表
     * @return UserDto列表
     */
    public static List<UserDto> buildDtoList(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }
        List<UserDto> userDtoList = new LinkedList<>();
        userList.forEach(user -> {
            if (user != null) {
                userDtoList.add(buildDto(user));
            }
        });
        return userDtoList;
    }

    /**
     * 将userDto的属性拷贝给user
     *
     * @param userDto UserDto
     * @param user    User实体
     */
    private static void toEntity(UserDto userDto, User user) {
        if (user != null && userDto != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            //对密码进行md5加密
            user.setPassword(EncryptUtil.encrypt(userDto.getPassword()));
        }
    }

    /**
     * 返回拷贝属性后的user
     *
     * @param userDto UserDto
     * @return User
     */
    public static User buildEntity(UserDto userDto) {
        if (userDto != null) {
            User user = new User();
            toEntity(userDto, user);
            return user;
        }
        return null;
    }

    /**
     * 返回拷贝属性后的user列表
     *
     * @param userDtoList UserDto列表
     * @return User列表
     */
    public static List<User> buildEntityList(List<UserDto> userDtoList) {
        if (CollectionUtils.isEmpty(userDtoList)) {
            return Collections.emptyList();
        }
        List<User> userList = new LinkedList<>();
        userDtoList.forEach(userDto -> {
            if (userDto != null) {
                userList.add(buildEntity(userDto));
            }
        });
        return userList;
    }


}
