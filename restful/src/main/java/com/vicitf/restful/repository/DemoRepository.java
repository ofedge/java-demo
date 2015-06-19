package com.vicitf.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vicitf.restful.demo.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {
	@Modifying
	@Query(value = "update Demo set text = ?1, number = ?2 where id = ?3")
	int updateDemo(String text, int number, Long id);
}
