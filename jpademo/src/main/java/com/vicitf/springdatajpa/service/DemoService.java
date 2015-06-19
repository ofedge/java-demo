package com.vicitf.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springdatajpa.domain.SchemaTables;
import com.vicitf.springdatajpa.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository dr;
	
	/**
	 * 查询所有数据库的表(不包含test, mysql, information_schema)
	 * @return
	 */
	public List<SchemaTables> findAllSchemaTables() {
		List<Object[]> list = dr.findAllSchemaTables();
		List<SchemaTables> stList = null;
		if (list != null && list.size() > 0) {
			stList = new ArrayList<SchemaTables>();
			for (Object[] obj : list) {
				SchemaTables st = new SchemaTables(obj[0].toString(), obj[1].toString());
				stList.add(st);
			}
		}
		return stList;
	}
	
	
	/**
	 * 根据每条SchemaTables查出对应表的总行数
	 * 
	 * @param schemaTables
	 * @return
	 */
	public int findTableRows(SchemaTables schemaTables) {
		return dr.getTableRows(schemaTables);
	}
}
