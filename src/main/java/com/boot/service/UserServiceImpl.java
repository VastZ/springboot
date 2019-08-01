package com.boot.service;

import com.boot.db.dao.UserMapper;
import com.boot.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    public List<User> getUserByAge(int age) {
        return userMapper.getUserByAge(age);
    }



}
