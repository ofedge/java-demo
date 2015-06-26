package com.vicitf.mongodb.demo.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.mongodb.demo.Application;
import com.vicitf.mongodb.demo.domain.Customer;
import com.vicitf.mongodb.demo.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository cr;
	
	@Test
	public void findByFirstNameTest() {
		List<Customer> list = cr.findAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
