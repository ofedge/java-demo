package com.vicitf.bootcss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vicitf.bootcss.domain.Person;
import com.vicitf.bootcss.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pr;
	
	public Page<Person> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}
}
