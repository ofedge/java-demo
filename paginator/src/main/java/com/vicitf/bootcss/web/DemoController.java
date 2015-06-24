package com.vicitf.bootcss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.bootcss.domain.Demo;
import com.vicitf.bootcss.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	private DemoService ds;
	
	@RequestMapping(value = "/demos", method = RequestMethod.GET)
	@ResponseBody
	public Page<Demo> findAll(int page, int size) {
		return ds.findAll(new PageRequest(page, size));
	}
}
