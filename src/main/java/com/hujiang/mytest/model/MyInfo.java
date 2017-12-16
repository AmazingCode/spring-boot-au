package com.hujiang.mytest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
public class MyInfo implements Serializable {

    private Long id;

    private String name;

    private String passWord;
    public static MyInfo builder()
    {
        return new MyInfo();
    }
    public MyInfo id(Long id)
    {
        this.id=id;
        return this;
    }
    public MyInfo name(String name)
    {
        this.name=name;
        return this;
    }
    public MyInfo passWord(String passWord)
    {
        this.passWord=passWord;
        return this;
    }
}
