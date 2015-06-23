package com.vicitf.bootcss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.bootcss.domain.Person;
import com.vicitf.bootcss.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService ps;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	@ResponseBody
	public Page<Person> findAllPersons(int page, int size) {
		return ps.findAll(new PageRequest(page, size));
	}
}
