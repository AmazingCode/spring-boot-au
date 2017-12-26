package com.hujiang.mytest.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口统一返回实体
 * */
@Data
public class Response<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public static <M>Response ok(M m)
    {
        Response<M> result=new Response<>();
        result.setStatus(0);
        result.setMessage("success");
        result.setData(m);
        return result;
    }
}
