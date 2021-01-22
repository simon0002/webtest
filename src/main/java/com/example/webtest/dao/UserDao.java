package com.example.webtest.dao;

import com.example.webtest.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User Sel(Integer id);

    boolean Add(String userName, String passWord, String realName);

    @Select("select * from user where userName = #{userName} limit 1")
    User getByName(String userName);

    //@Select("select * from user limit #{start}, #{end}")
    List<User> list(User user);

    @Select("select * from user")
    List<User> lists();

    @Select("select count(id) from user")
    Integer count();

}
