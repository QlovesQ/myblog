package com.st.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.domain.ResponseResult;
import com.st.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-03-15 19:58:38
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();
}

