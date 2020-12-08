package com.wyz.user.controller;

import com.wyz.user.bean.common.ConstantPool;
import com.wyz.user.bean.entity.User;
import com.wyz.user.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户表(User)表控制层
 *
 * @author wangyizhong
 * @since 2020-11-05 16:21:43
 */
@RestController
@RequestMapping
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private IUserService userService;

    /**
     * javadoc logout
     * 退出登录
     *
     * @param response 响应
     * @return Integer
     * @author wyz
     * @date 2020/11/6 17:55
     **/
    @GetMapping("logout")
    public Integer logout(HttpServletResponse response) {
        resetCookie(response);
        return 1;
    }

    private void resetCookie(HttpServletResponse response) {
        final Cookie cookie = new Cookie(ConstantPool.SHADOW_TOKEN, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/inner/selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @GetMapping("/selectOne")
    public User selectOneById(Long id) {
        return this.userService.queryById(id);
    }

}