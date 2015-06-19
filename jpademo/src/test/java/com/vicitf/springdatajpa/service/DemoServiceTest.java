package com.vicitf.springdatajpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.domain.SchemaTables;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoServiceTest {
	@Autowired
	private DemoService ds;
	
	@Test
	public void findAllShcemaTablesTest() {
		List<SchemaTables> list = ds.findAllSchemaTables();
		for (SchemaTables schemaTables : list) {
			System.out.println(schemaTables);
		}
	}
	
	@Test
	public void findTableRowsTest() {
		SchemaTables st = new SchemaTables("test", "t_schema_tables");
		int i = ds.findTableRows(st);
		System.out.println(i);
	}
}
