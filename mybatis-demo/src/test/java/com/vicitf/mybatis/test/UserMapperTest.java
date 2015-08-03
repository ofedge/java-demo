package com.vicitf.mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.mybatis.domain.User;
import com.vicitf.mybatis.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void getStudentTest(){
		User user = userMapper.getUser(1L);
		System.out.println(user);
		List<User> list = userMapper.getAllUser();
		for (User u : list) {
			System.out.println(u);
		}
	}
}
