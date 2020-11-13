package com.ssm.domain.dto;

import java.io.Serializable;

/**
 * User数据传输对象
 *
 * @author wqy
 * @version 1.0 2020/11/11
 */
public class UserDto implements Serializable {

    //id
    private String id;

    //编号
    private int number;

    //姓名
    private String name;

    //年龄
    private int age;

    //性别
    private String gender;

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
