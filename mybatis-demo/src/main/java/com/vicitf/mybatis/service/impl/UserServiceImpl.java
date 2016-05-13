package com.vicitf.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.mybatis.domain.User;
import com.vicitf.mybatis.mapper.UserMapper;
import com.vicitf.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }

}
