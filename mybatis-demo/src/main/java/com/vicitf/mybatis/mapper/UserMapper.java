package com.vicitf.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vicitf.mybatis.domain.User;

@Repository
public interface UserMapper {
    
    User getUser(Long id);

    List<User> getAllUser();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
