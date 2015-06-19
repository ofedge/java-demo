package com.vicitf.restful.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.restful.Application;
import com.vicitf.restful.demo.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoServiceTest {
	@Autowired
	private DemoService ds;

	@Test
	public void getTest() {
		Demo d = ds.findById(1L);
		System.out.println(d);
	}
}
