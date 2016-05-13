package com.vicitf.mybatis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.mybatis.domain.User;
import com.vicitf.mybatis.service.UserService;

@Controller
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String indexPage(Model model){
	    List<User> list = userService.getAllUser();
		model.addAttribute("users", list);
		return "index";
	}
}
