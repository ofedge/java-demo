package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoRepositoryTest {
	@Autowired
	private DemoRepository dr;
	
	@Test
	public void findAllTableTest() {
		List<Object[]> list = dr.findAllSchemaTables();
		for (Object[] object : list) {
			System.out.println(object[0] + ", " + object[1]);
		}
	}
	
}
