package com.sise.service;

import com.sise.pojo.Comment;

import java.util.List;

public interface CommentService {
    //查询评论
    List<Comment> listCommentByBlogId(Long blogId);
    //增加评论
    int saveComment(Comment comment);


}
