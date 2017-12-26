package com.hujiang.mytest.service.fade;

import com.hujiang.mytest.model.LogInInfo;

public interface IJwtService {
    String getJWT_HS512(LogInInfo info);
    LogInInfo parseJWT_HS512Token(String token);
}
