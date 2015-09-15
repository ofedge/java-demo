package com.vicitf.xml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.xml.domain.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
