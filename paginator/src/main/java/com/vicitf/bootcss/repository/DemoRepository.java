package com.vicitf.bootcss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.bootcss.domain.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
