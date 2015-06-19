package com.vicitf.springdatajpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.bean.ChangedTableBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class QueryServiceTest {
	@Autowired
	private QueryService qs;
	
	@Test
	public void getChangedTablesTest() {
		List<ChangedTableBean> list = qs.getChangedTables(5, 6);
		for (ChangedTableBean changedTableBean : list) {
			System.out.println(changedTableBean);
		}
	}
}
