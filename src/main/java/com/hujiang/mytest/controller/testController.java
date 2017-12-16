package com.hujiang.mytest.controller;

import com.hujiang.mytest.model.JWT;
import com.hujiang.mytest.model.LogInInfo;
import com.hujiang.mytest.model.MyInfo;
import com.hujiang.mytest.model.Response;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/test")
public class testController {

    /**
     * 默认返回json
     * */
    @GetMapping(value = "info1/{id}")
    public Response<MyInfo> getInfo(@PathVariable Long id)
    {
        return Response.ok(MyInfo.builder()
                            .id(id)
                            .name("lhj")
                            .passWord("4800155")) ;
    }

    /**
     * 根据用户名密码生成token
     * */
    @PostMapping("create/token")
    public Response<String> createJWTToken(@RequestBody LogInInfo logInInfo)
    {
        return Response.ok(JWT.getJWT_HS512(logInInfo));
    }

    /**
     * 将用户token解析成用户信息
     * */
    @GetMapping("parse/token")
    public Response<LogInInfo> parseJWTToken(HttpServletRequest request)
    {
       String token=request.getHeader("access_token");
       return Response.ok(JWT.parseJWT_HS512Token(token));
    }

}
