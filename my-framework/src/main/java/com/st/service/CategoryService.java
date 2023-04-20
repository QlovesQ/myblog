package com.st.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Category;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 12:53:03
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

