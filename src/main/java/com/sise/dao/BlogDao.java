package com.sise.dao;

import com.sise.pojo.Blog;
import com.sise.querypojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {
    /*查询所有博客列表*/
    List<BlogQuery> getAllBlogQuery();
    /*搜索组合查询*/
    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);
    /*新增博客*/
    int saveBlog(Blog blog);
    /*编辑博客*/
    int updateBlog(ShowBlog showBlog);
    /*通过id搜索博客篇章（编辑博客）*/
    ShowBlog getBlogById(Long id);
    /*删除博客*/
    int deleteBlog(Long id);
    /*首页展示博客*/
    List<FirstPageBlog> getFirstPageBlog();
    /*文章推荐*/
    List<RecommendBlog> getAllRecommendBlog();
    /*分类列表*/
    List<TypeList> getTypeList();
    /*前端分类页面，根据分类id查找博客相关内容*/
    List<FirstPageBlog> getByTypeId(Long typeId);
    /*前端博客详情页*/
    DetailedBlog getDetailedBlog(Long id);
    /*文章访问数量自增*/
    int updateViews(Long id);
    /*根据博客id查询出评论数量*/
    int getCommentCountById(Long id);
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
