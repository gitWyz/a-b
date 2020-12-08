package com.wyz.user.bean.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户表(User)实体类
 *
 * @author wangyizhong
 * @since 2020-11-05 16:21:40
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 571910950959092116L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户code
    */
    private String userCode;
    /**
    * 用户姓名
    */
    private String userName;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 加盐密码
    */
    private String passwordSalt;
    /**
    * 密码hash值
    */
    private String passwordHash;
    /**
    * 状态0停用1启用
    */
    private Integer userStatus;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 创建时间
    */
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    private String updateBy;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;


}