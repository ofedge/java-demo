package com.vicitf.springdatajpa.bean;

public class PersonBean {
	private String name;
	private String email;
	private Integer age;
	private String gender;
	private String country;
	
	public PersonBean() {
	}

	public PersonBean(String name, String email, Integer age, String gender, String country) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", country=" + country + "]";
	}

}
