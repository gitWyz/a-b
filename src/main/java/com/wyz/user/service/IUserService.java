package com.wyz.user.service;

import com.wyz.user.bean.dto.RegisterDTO;
import com.wyz.user.bean.dto.UserLoginDTO;
import com.wyz.user.bean.entity.User;
import com.wyz.user.bean.vo.UserVO;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author wangyizhong
 * @since 2020-11-05 16:21:42
 */
public interface IUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * @apiNote 用户登录
     *
     * @param dto 登录参数
     * @return com.wyz.user.bean.vo.UserVO
     * @author wangyizhong
     * @date 2020/11/6 11:29
     */
    UserVO login(UserLoginDTO dto);

    /**
     * @apiNote 用户注册
     *
     * @param dto 注册参数
     * @return java.lang.Integer
     * @author wangyizhong
     * @date 2020/11/6 15:24
     */
    Integer register(RegisterDTO dto);
}