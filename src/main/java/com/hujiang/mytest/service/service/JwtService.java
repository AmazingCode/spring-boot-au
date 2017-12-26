package com.hujiang.mytest.service.service;

import com.hujiang.mytest.model.LogInInfo;
import com.hujiang.mytest.service.fade.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token相关
 * */
@Service
public class JwtService implements IJwtService {

    /**
     *  token签名
     * */

    @Value("${token.secretKey}")
    private String secret;

    /**
     * 加密登陆用户信息
     * @param info 登陆信息
     * @return  token
     */
    @Override
    public  String getJWT_HS512(LogInInfo info)
    {
        System.out.println(secret);
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
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     *  解析HS512加密的token
     * @param token
     * @return
     */
    @Override
    public  LogInInfo parseJWT_HS512Token(String token)
    {
        //解析token，如果解析失败（过期，无效token等等）将抛异常
        Claims claims= Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return LogInInfo.builder()
                .name(claims.get("userName").toString())
                .passWord(claims.get("passWord").toString());
    }
}
