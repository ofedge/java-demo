package com.vicitf.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vicitf.restful.demo.Demo;
import com.vicitf.restful.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository dr;
	
	public Demo findById(Long id) {
		return dr.findOne(id);
	}
	
	public Demo add(Demo demo) {
		return dr.save(demo);
	}
	
	@Transactional
	public int update(Demo demo) {
		return dr.updateDemo(demo.getText(), demo.getNumber(), demo.getId());
	}
	
	@Transactional
	public void deleteById(Long id) {
		dr.delete(id);
	}
	
}
