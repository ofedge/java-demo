package com.vicitf.springdatajpa.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.domain.Changes;
import com.vicitf.springdatajpa.domain.TableChanges;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ChangesServiceTest {
	@Autowired
	private ChangeService cs;
	
	/**
	 * 仅第一次测试用!!!
	 */
	public void newChangesTest() {
		Changes changes = new Changes();
		changes.setChangeNums(1);
		changes.setChangeAction("第一次修改, 测试, 无任务动作");
		changes.setChangeTime(new Date());
		List<TableChanges> list = cs.newChange(changes);
		for (TableChanges tableChanges : list) {
			System.out.println(tableChanges);
		}
	}
	
	/**
	 * 修改动作
	 */
	@Test
	public void newChangesTestN() {
		Changes changes = new Changes();
		changes.setChangeNums(43);
		changes.setChangeAction("record");
		changes.setChangeTime(new Date());
		List<TableChanges> list = cs.newChange(changes);
		for (TableChanges tableChanges : list) {
			System.out.println(tableChanges);
		}
	}
	
}
