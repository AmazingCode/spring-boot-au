package com.hujiang.mytest.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {
    public static String getJWT_HS512(LogInInfo info)
    {
        //设置Claims将一些信息放入到token的payload中
        Map<String,Object> claims=new HashMap();
        claims.put("userName",info.getName());
        claims.put("passWord",info.getPassWord());

        //过期时间设置为一天
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date expireTime=calendar.getTime();

        //使用HS512算法进行token加密
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS512, LogInInfo.secret)
                .compact();
    }
    public static LogInInfo parseJWT_HS512Token(String token)
    {
        //解析token，如果解析失败（过期，无效token等等）将抛异常
        Claims claims= Jwts.parser()
                .setSigningKey(LogInInfo.secret)
                .parseClaimsJws(token)
                .getBody();

        return LogInInfo.builder()
                .name(claims.get("userName").toString())
                .passWord(claims.get("passWord").toString());
    }
}
