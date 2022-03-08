package com.sise.service;


import com.sise.pojo.Type;

import java.util.List;

public interface TypeService {
    /*查询所有分类*/
    List<Type> getAllType();
    /*查询分类名*/
    Type getTypeByName(String name);
    /*增加一个分类*/
    int saveType(Type type);
    /*查询分类id*/
    Type getType(Long id);
    /*更新分类*/
    int updateType(Type type);
    /*删除分类*/
    int deleteType(Long id);
    /*前端分类页面，查询分类及博客相关信息*/
    List<Type>getAllTypeAndBlog();
}
