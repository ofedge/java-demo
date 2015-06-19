package com.vicitf.springdatajpa.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 查询用类, 不要有任何修改或修改相关动作
 * 
 * @author silcata
 *
 */
@Repository
public class QueryRepository {
	@Autowired
	private EntityManager entityManger;
	
}
