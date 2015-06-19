package com.vicitf.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springdatajpa.domain.TableChanges;

public interface TableChangesRepository extends JpaRepository<TableChanges, Long> {
}
