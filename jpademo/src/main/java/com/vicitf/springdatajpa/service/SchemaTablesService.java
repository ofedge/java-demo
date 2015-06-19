package com.vicitf.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springdatajpa.domain.SchemaTables;
import com.vicitf.springdatajpa.repository.SchemaTablesRepository;

@Service
public class SchemaTablesService {
	@Autowired
	private SchemaTablesRepository str;
	@Autowired
	private DemoService ds;
	
	/**
	 * 填充SchemaTables表
	 * 
	 * 不要再调用!!!
	 * @return
	 */
	public List<SchemaTables> fillTables() {
		List<SchemaTables> list = ds.findAllSchemaTables();
		return str.save(list);
	}
	
	/**
	 * 获取SchemaTables所有记录
	 * 
	 * @return
	 */
	public List<SchemaTables> findAll() {
		return str.findAll();
	}
	
}
