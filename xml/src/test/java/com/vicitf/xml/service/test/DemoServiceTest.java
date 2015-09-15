package com.vicitf.xml.service.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.xml.Application;
import com.vicitf.xml.bean.DemoBean;
import com.vicitf.xml.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoServiceTest {
	@Autowired
	private DemoService demoService;
	
	@Test
	public void findAll() {
		List<DemoBean> list = demoService.findAll();
		Iterator<DemoBean> it = list.iterator();
		while (it.hasNext()) {
			DemoBean demo = it.next();
			System.out.println(demo);
		}
	}
}
