package com.hujiang.mytest.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class LogInInfo implements Serializable {

    public static final String secret="xxxxx";

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
