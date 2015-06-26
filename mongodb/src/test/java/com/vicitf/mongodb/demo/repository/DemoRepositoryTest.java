package com.vicitf.mongodb.demo.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.WriteResult;
import com.vicitf.mongodb.demo.Application;
import com.vicitf.mongodb.demo.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoRepositoryTest {
	@Autowired
	private DemoRepository dr;
	
	@Test
	public void findAllCustomerTest() {
		List<Customer> list = dr.queryCustomersByFirstName("Tom");
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void updateLastNameByFirstNameTest() {
		WriteResult result = dr.updateLastNameByFirstName("Tom", "Hanks");
		// result如果直接toString()得到的结果是N/A, 先获取一个属性值再toString()就好了..就好了.
		System.out.println(result.getN() + ": " + result.toString());
	}
	
	@Test
	public void setAgeByFirstNameTest() {
		WriteResult result = dr.setAgeByFirstName("Jon", 17);
		System.out.println(result.getN() + ": " + result.toString());
	}
	
	@Test
	public void incAgeByFirstNameTest() {
		WriteResult result = dr.incAgeByFirstName("Bran", 1);
		System.out.println(result.getN() + ": " + result.toString());
	}
	
	@Test
	public void insertCustomerTest() {
		dr.insertCustomer(new Customer("Bran", "Stark", 12));
		// 插入之后的记录中有个 _class 字段
	}
	
	@Test
	public void removeByFirstNameTest() {
		WriteResult result = dr.removeByFirstName("Bran");
		System.out.println(result.getN() + ": " + result.toString());
	}
}
