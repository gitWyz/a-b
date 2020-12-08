package com.wyz.user.controller;

import com.wyz.user.bean.dto.RegisterDTO;
import com.wyz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 *
 * @author wangyizhong
 * @version 1.0
 * @date 2020-11-06 15:12
 **/
@RestController
@RequestMapping("/outer/user")
public class UserRegisterController {

    private IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Integer register(@RequestBody RegisterDTO dto) {
        return userService.register(dto);
    }
}
