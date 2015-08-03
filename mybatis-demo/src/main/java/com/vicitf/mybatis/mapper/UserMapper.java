package com.vicitf.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicitf.mybatis.domain.User;

@Repository
@Transactional
public interface UserMapper {
	public User getUser(Long id);
	public List<User> getAllUser();
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}
