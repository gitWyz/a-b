package com.wyz.user.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 登录请求参数
 * @author wangyizhong
 * @date 2020/11/06 10:13
 * @version 1.0
 **/
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserLoginDTO {
    /**
     * 登录手机号
     **/
    private String phone;

    /**
     * 登录密码
     **/
    private String password;
}
