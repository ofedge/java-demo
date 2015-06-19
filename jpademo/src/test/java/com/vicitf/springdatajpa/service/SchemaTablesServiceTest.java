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
public class SchemaTablesServiceTest {
	@Autowired
	private SchemaTablesService sts;
	
	/**
	 * 不要再调用!!!
	 */
	public void fillTabelsTest() {
		List<SchemaTables> list = sts.fillTables();
		for (SchemaTables schemaTables : list) {
			System.out.println(schemaTables);
		}
	}
	
	@Test
	public void findAllTest() {
		List<SchemaTables> list = sts.findAll();
		System.out.println("总条数: " + list.size());
		for (SchemaTables schemaTables : list) {
			System.out.println(schemaTables);
		}
	}
}
