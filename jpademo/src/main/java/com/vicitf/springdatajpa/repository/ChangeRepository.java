package com.vicitf.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springdatajpa.domain.Changes;

public interface ChangeRepository extends JpaRepository<Changes, Long> {
	
}
