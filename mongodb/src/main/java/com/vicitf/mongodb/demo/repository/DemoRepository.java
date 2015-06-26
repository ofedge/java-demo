package com.vicitf.mongodb.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.vicitf.mongodb.demo.domain.Customer;

@Repository
public class DemoRepository {
	@Autowired
	public MongoTemplate template;
	
	public List<Customer> queryCustomersByFirstName(String firstName) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		return template.find(query, Customer.class);
	}
	
	public WriteResult updateLastNameByFirstName(String firstName, String lastName) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		Update update = new Update().set("lastName", lastName);
		return template.updateMulti(query, update, Customer.class);
	}
	
	public WriteResult setAgeByFirstName(String firstName, int age) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		Update update = new Update().set("age", age);
		return template.updateMulti(query, update, Customer.class);
	}
	
	public WriteResult incAgeByFirstName(String firstName, int size) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		Update update = new Update().inc("age", size);
		return template.updateMulti(query, update, Customer.class);
	}
	
	public void insertCustomer(Customer customer) {
		template.insert(customer);
	}
	
	public WriteResult removeByFirstName(String firstName) {
		Query query = new Query(Criteria.where("firstName").is(firstName));
		return template.remove(query, Customer.class);
	}
}
