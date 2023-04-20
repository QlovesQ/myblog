package com.st.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.constants.SystemConstants;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Article;
import com.st.domain.entity.Category;
import com.st.domain.vo.CategoryVo;
import com.st.mapper.CategoryMapper;
import com.st.service.ArticleService;
import com.st.service.CategoryService;
import com.st.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 12:53:04
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {

        //查询文章表，状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> list = articleService.list(articleWrapper);

        //获取文章的分类id，并且去重
        Set<Long> categoryIds = list.stream()
                .map(article -> article.getCategoryId())
                //set表示去重
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);

        categories = categories.stream().filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories,CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}

