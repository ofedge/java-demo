package com.vicitf.springdatajpa.service;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.domain.TableChanges;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TableChangesServiceTest {
	@Autowired
	private TableChangesService tcs;
	
	/**
	 * 初始化表行数, 所以changeId为0
	 * 测试完成后不要再运行
	 */
	public void fillTableChangesTest() {
		List<TableChanges> list = tcs.fillTableChanges(0);
		for (TableChanges tableChanges : list) {
			System.out.println(tableChanges);
		}
	}
}
