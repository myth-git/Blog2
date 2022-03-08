package com.sise.service.impl;

import com.sise.dao.TypeDao;
import com.sise.pojo.Type;
import com.sise.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    /*查询所有分类*/
    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }
    /*查询分类名*/
    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    /*插入一个分类*/
    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        List<Type> allTypeAndBlog = typeDao.getAllTypeAndBlog();
        return allTypeAndBlog;
    }
}
