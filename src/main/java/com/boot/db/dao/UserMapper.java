package com.boot.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.boot.db.pojo.User;

@Mapper
public interface UserMapper {
    
    /**
     * 字段映射   `update` 遇到关键字当做查询字段时，使用反引号
     */
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "uid", id = true),
            @Result(property = "phone", column = "mobile"),
            @Result(property = "name", column = "name")
          })
    @Select("select * from user where age = #{age}")
    public List<User> getUserByAge(int age);
    
    
}
