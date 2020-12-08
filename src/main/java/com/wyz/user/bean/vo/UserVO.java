package com.wyz.user.bean.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wangyizhong
 * @date 2020/11/06 10:17
 * @version 1.0
 **/
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserVO {
    /**
     * id
     **/
    private Long id;

    /**
     * 用户唯一code
     **/
    private String userCode;

    /**
     * 用户名
     **/
    private String userName;

    /**
     * 手机号
     **/
    private String phone;

    /**
     * 用户状态
     **/
    private Integer state;

    /**
     * 账号生成时间
     **/
    private LocalDateTime createTime;

    /**
     * 授权token
     **/
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String token;

}
