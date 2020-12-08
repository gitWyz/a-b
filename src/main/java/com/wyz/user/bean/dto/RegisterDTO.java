package com.wyz.user.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 注册dto
 *
 * @author wangyizhong
 * @version 1.0
 * @date 2020-11-06 15:14
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RegisterDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
}
