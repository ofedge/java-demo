package com.vicitf.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springdatajpa.domain.SchemaTables;

public interface SchemaTablesRepository extends JpaRepository<SchemaTables, Long> {
	
	@SuppressWarnings("unchecked")
	SchemaTables save(SchemaTables schemaTables);
	
	List<SchemaTables> findAll();
	
}
