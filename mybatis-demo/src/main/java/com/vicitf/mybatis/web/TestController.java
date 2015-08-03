package com.vicitf.mybatis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.mybatis.domain.User;
import com.vicitf.mybatis.mapper.UserMapper;

@Controller
public class TestController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/")
	public String indexPage(Model model){
		User user = userMapper.getUser(1L);
		System.out.println(user);
		model.addAttribute("user", user);
		return "index";
	}
}
