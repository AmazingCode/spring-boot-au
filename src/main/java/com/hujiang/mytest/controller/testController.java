package com.hujiang.mytest.controller;

import com.hujiang.mytest.model.LogInInfo;
import com.hujiang.mytest.model.Response;
import com.hujiang.mytest.model.UserInfo;
import com.hujiang.mytest.service.fade.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("v1/test")
public class testController {

    @Value("${token.secretKey}")
    private String secret;

    @Autowired
    private IJwtService jwtService;
    /**
     * 默认返回json
     * */
    @GetMapping(value = "info1/{id}")
    public Response<UserInfo> getInfo(@PathVariable Long id)
    {
        return Response.ok(UserInfo.builder()
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
        System.out.println(secret);
        System.out.println(jwtService.getJWT_HS512(logInInfo));
        return Response.ok(jwtService.getJWT_HS512(logInInfo));
    }

    /**
     * 将用户token解析成用户信息
     * */
    @GetMapping("parse/token")
    public Response<LogInInfo> parseJWTToken(HttpServletRequest request)
    {
       String token=request.getHeader("access_token");
       return Response.ok(jwtService.parseJWT_HS512Token(token));
    }

}
