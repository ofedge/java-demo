package com.vicitf.springdatajpa.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vicitf.springdatajpa.bean.PersonBean;
import com.vicitf.springdatajpa.domain.Country;
import com.vicitf.springdatajpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("select new com.vicitf.springdatajpa.bean.PersonBean(p.name, p.email, p.age, p.gender, p.country.name) from Person p")
	List<PersonBean> findPersonBean();
	
	@Query("select new map(max(age) as max, min(age) as min, count(*) as n) from Person")
	Map<String, Object> findMap();
	
	@Query("select new list(p.name, p.email, c.name) from Person p inner join p.country c")
	List<List<Object>> findList();
	
	@Query("select new com.vicitf.springdatajpa.bean.PersonBean(p.name, p.email, p.age, p.gender, p.country.name) from Person p where p.country = ?1")
	List<PersonBean> findCityPerson(Country country);
	
	@Query("select p from Person p where p.country.id = ?1")
	List<Person> findPersonByCountryId(Long id);
	
	@Query("select count(*) from Person p")
	int countPersons();
	
	@Query("select c from Person p inner join p.country c group by c.id having count(p.id) > ?1")
	List<Country> findCoutryByPersonCnt(Long amount);
}
