package com.boot.service;

import java.util.List;

import com.boot.db.pojo.User;

public interface UserService {
    public List<User> getUserByAge(int age);
}
