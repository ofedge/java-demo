package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vicitf.springdatajpa.bean.PersonBean;

@Repository
public class PersonDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonBean> findPersonBean() {
		String hql = "select new com.vicitf.springdatajpa.bean.PersonBean(p.name, p.email, p.age, p.gender, p.country.name) from Person p";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
}
