package com.hujiang.mytest.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息类
 * */
@Data
public class UserInfo implements Serializable {

    private Long id;

    private String name;

    private String passWord;

    private Long role;

    public static UserInfo builder()
    {
        return new UserInfo();
    }
    public UserInfo id(Long id)
    {
        this.id=id;
        return this;
    }
    public UserInfo name(String name)
    {
        this.name=name;
        return this;
    }
    public UserInfo passWord(String passWord)
    {
        this.passWord=passWord;
        return this;
    }
    public UserInfo role(Long role)
    {
        this.role=role;
        return this;
    }
}
