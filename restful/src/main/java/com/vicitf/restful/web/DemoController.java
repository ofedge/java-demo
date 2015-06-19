package com.vicitf.restful.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.restful.demo.Demo;
import com.vicitf.restful.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	private DemoService ds;
	
	@RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
	public Demo findById(@PathVariable("id")Long id) {
		return ds.findById(id);
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public int update(Demo demo) {
		return ds.update(demo);
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.PUT)
	public Demo add(Demo demo) {
		return ds.add(demo);
	}
	
	@RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id")Long id) {
		ds.deleteById(id);
	}
}
