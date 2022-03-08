package com.sise.service;

import com.sise.pojo.Blog;
import com.sise.querypojo.*;

import java.util.List;

public interface BlogService {
    /*查询所有博客*/
    List<BlogQuery> getAllBlogQuery();
    /*组合搜索博客*/
    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);
    /*新增博客*/
    int saveBlog(Blog blog);
    /*修改博客*/
    int updateBlog(ShowBlog showBlog);
    /*通过id查询修改博客*/
    ShowBlog getBlogById(Long id);
    /*删除博客*/
    int deleteBlog(Long id);
    /*首页展示博客*/
    List<FirstPageBlog> getAllFirstPageBlog();
    /*文章推荐*/
    List<RecommendBlog> getRecommendedBlog();
    /*分类列表*/
    List<TypeList> getTypeList();
    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);
    /*前端博客详情页*/
    DetailedBlog getDetailedBlog(Long id);
    /*博客信息-博客总数*/
    Integer getBlogTotal();
    /*博客信息-博客阅读总数*/
    Integer getBlogViewTotal();
    /*博客信息-博客评论总数*/
    Integer getBlogCommentTotal();
    /*博客信息-博客留言总数*/
    Integer getBlogMessageTotal();
    /*搜索文章*/
    List<FirstPageBlog> getSearchBlog(String query);
}
