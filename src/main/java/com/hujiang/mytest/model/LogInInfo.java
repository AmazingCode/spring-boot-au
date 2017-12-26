package com.hujiang.mytest.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登陆信息类
 * */
@Data
public class LogInInfo implements Serializable {

    private String name;

    private String passWord;

    private LogInInfo()
    {}

    public static LogInInfo builder()
    {
        return new LogInInfo();
    }
    public LogInInfo name(String name)
    {
        this.name=name;
        return  this;
    }
    public LogInInfo passWord(String passWord)
    {
        this.passWord=passWord;
        return  this;
    }

}
