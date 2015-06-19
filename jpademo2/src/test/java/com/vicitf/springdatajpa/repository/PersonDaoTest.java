package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.bean.PersonBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonDaoTest {
	@Autowired
	private PersonDao pd;
	
	@Test
	public void findCountryBeanTest() {
		List<PersonBean> list = pd.findPersonBean();
		for (PersonBean p : list) {
			System.out.println(p);
		}
	}
}
