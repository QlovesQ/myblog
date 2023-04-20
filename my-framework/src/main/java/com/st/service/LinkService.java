package com.st.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-03-04 14:43:52
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

