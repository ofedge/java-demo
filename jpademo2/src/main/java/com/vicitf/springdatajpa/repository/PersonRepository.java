package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vicitf.springdatajpa.bean.PersonBean;
import com.vicitf.springdatajpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("select new com.vicitf.springdatajpa.bean.PersonBean(p.name, p.email, p.age, p.gender, p.country.name) from Person p")
	List<PersonBean> findPersonBean();
}
