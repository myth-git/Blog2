package com.sise.dao;

import com.sise.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    User findUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}
