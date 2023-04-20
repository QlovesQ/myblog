package com.st.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageNum1, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
