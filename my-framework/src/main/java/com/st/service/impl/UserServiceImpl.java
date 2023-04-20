package com.st.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.domain.ResponseResult;
import com.st.domain.entity.User;
import com.st.domain.vo.UserInfoVo;
import com.st.mapper.UserMapper;
import com.st.service.UserService;
import com.st.utils.BeanCopyUtils;
import com.st.utils.SecurityUtils;
import org.springframework.stereotype.Service;


/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-03-15 19:58:39
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {
        //获取当前用户id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        //封装成UserInfoVo
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }
}

