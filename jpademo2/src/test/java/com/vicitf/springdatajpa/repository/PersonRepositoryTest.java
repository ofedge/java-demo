package com.vicitf.springdatajpa.repository;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springdatajpa.Application;
import com.vicitf.springdatajpa.bean.PersonBean;
import com.vicitf.springdatajpa.domain.Country;
import com.vicitf.springdatajpa.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonRepository pr;
	
	@Test
	public void test() {
		System.out.println(">>>>> count: " + pr.count());
		List<Person> list = pr.findAll();
		for (Person p : list) {
			System.out.println(">>>>> " + p);
		}
	}
	
	@Test
	public void findMapTest() {
		Map<String, Object> map = pr.findMap();
		for (Object obj : map.keySet()) {
			System.out.println(obj.toString() + " >>> " + map.get(obj));
		}
	}
	
	@Test
	public void findListTest() {
		List<List<Object>> list = pr.findList();
		for (List<Object> objList : list) {
			for (Object object : objList) {
				System.out.print(" >> " + object);
			}
			System.out.println();
		}
	}
	
	@Test
	public void findCityPersonTest() {
//		Country c = new Country("China", "Eastern Asia", "CHN");
		Country c = new Country(5L, "China", "Eastern Asia", "CHN");
		List<PersonBean> list = pr.findCityPerson(c);
		for (PersonBean personBean : list) {
			System.out.println(personBean);
		}
	}
	
	@Test
	public void findPersonByCountryIdTest() {
		List<Person> list = pr.findPersonByCountryId(5L);
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	@Test
	public void countPersonsTest() {
		int i = pr.countPersons();
		System.out.println(i);
	}
	
	@Test
	public void findCoutryByPersonCntTest() {
		List<Country> list = pr.findCoutryByPersonCnt(7L);
		for (Country country : list) {
			System.out.println(country);
		}
	}
	
}
