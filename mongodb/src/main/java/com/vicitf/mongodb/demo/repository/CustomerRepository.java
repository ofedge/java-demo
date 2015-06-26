package com.vicitf.mongodb.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vicitf.mongodb.demo.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
