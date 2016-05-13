package com.vicitf.mybatis.service;

import java.util.List;

import com.vicitf.mybatis.domain.User;

public interface UserService {
    
    User getUser(Long id);

    List<User> getAllUser();

    int insertUser(User user);
    
    int updateUser(User user);
    
    int deleteUser(Long id);
}
