package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonRepository pr;
	@Autowired
	private PersonDao pd;
	
	@Test
	public void test() {
		System.out.println(">>>>> count: " + pr.count());
		List<Person> list = pr.findAll();
		for (Person p : list) {
			System.out.println(">>>>> " + p);
		}
	}
	
}
