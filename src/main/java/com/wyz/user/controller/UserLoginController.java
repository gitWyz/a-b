package com.wyz.user.controller;


import com.wyz.user.bean.common.ConstantPool;
import com.wyz.user.bean.dto.UserLoginDTO;
import com.wyz.user.bean.vo.UserVO;
import com.wyz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录Controller
 *
 * @author wangyizhong
 * @version 1.0
 * @date 2020-11-06 09:54
 **/
@RestController
@RequestMapping("/outer/user")
public class UserLoginController {

    private IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 登录
     *
     * @param dto 用户登录信息
     * @return UserVO
     * @author wangyizhong
     * @date 2020/9/7 16:31
     */
    @PostMapping("login")
    public UserVO login(@RequestBody UserLoginDTO dto, HttpServletResponse response) {
        final UserVO vo = userService.login(dto);
        final Cookie cookie = new Cookie(ConstantPool.SHADOW_TOKEN, vo.getToken());
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        response.addCookie(cookie);
        return vo;
    }
}
