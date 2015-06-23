package com.vicitf.bootcss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.bootcss.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
