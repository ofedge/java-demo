package com.vicitf.mongodb.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
@TypeAlias("customer") // 类别名, 显示为collection的_class字段值
public class Customer {
	@Id
	private String id;
	@Field(value = "firstName")
	private String firstName;
	@Field(value = "lastName")
	private String lastName;
	@Field(value = "age")
	private Integer age;

	public Customer() {
	}

	public Customer(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}

}
