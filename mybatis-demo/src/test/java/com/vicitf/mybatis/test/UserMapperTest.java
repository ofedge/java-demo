package com.vicitf.mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.mybatis.domain.User;
import com.vicitf.mybatis.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class UserMapperTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void getStudentTest(){
		User user = userService.getUser(1L);
		System.out.println(getClass().getSimpleName() + ": " + user);
		List<User> list = userService.getAllUser();
		for (int i = 0; i < list.size(); i++) {
            System.out.println(getClass().getSimpleName() + " " + i + ": " + list.get(i));
        }
	}
	
	@Test
	public void addStudnetTest() {
	    User user = new User();
	    user.setName("anna");
	    user.setAge(11);
	    int i = userService.insertUser(user);
	    System.out.println(getClass().getSimpleName() + ": " + i);
	}
	
	@Test
	public void updateUserTest() {
	    User user = userService.getUser(1L);
	    System.out.println(getClass().getSimpleName() + ": before: " + user);
	    user.setName("elsa");
	    user.setAge(13);
	    int i = userService.updateUser(user);
	    System.out.println(getClass().getSimpleName() + ": " + i);
	}
	
	@Test
	public void deleteUserTest() {
	    Long id = 3L;
	    int i = userService.deleteUser(id);
	    System.out.println(getClass().getSimpleName() + ": " + i);
	}
}
