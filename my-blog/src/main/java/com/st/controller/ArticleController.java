package com.st.controller;

import com.st.domain.ResponseResult;
import com.st.domain.entity.Article;
import com.st.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @RequestMapping("/test")
//    public String test(){
//        return "成功了！！";
//    }

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        //查询热门文章，封装成 ResponseResult，返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        ResponseResult result = articleService.articleList(pageNum,pageNum,categoryId);
        return result;
    }

    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id ){
        return articleService.getArticleDetail(id);
    }
}
