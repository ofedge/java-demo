package com.vicitf.bootcss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vicitf.bootcss.domain.Demo;
import com.vicitf.bootcss.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository dr;
	
	public Page<Demo> findAll(Pageable pageable) {
		return dr.findAll(pageable);
	}
}
