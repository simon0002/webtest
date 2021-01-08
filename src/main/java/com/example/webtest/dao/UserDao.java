package com.example.webtest.dao;

import com.example.webtest.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User Sel(Integer id);

    boolean Add(String userName, String passWord, String realName);

    @Select("select * from user where userName = #{userName} limit 1")
    User getByName(String userName);

}
