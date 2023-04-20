package com.st.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Comment;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-03-09 17:44:17
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articled, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

