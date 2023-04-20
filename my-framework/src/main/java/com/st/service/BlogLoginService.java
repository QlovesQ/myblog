package com.st.service;

import com.st.domain.ResponseResult;
import com.st.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
