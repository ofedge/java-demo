package com.vicitf.springdatajpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vicitf.springdatajpa.domain.SchemaTables;

/**
 * 通用数据业务处理
 * 
 * @author silcata
 *
 */
@SuppressWarnings("unchecked")
@Repository
public class DemoRepository {
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * 获取所有数据库以及下面的表, 不包含test, mysql, information_schema
	 * 
	 * @return
	 */
	public List<Object[]> findAllSchemaTables() {
		String sql = "select table_schema, table_name from information_schema.tables where table_schema not in ('test','mysql','information_schema') order by table_schema";
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
	
	public int getTableRows(SchemaTables schemaTables) {
		String sql = "select count(1) from " + schemaTables.getSchemaName() + "." + schemaTables.getTableName();
		Query query = entityManager.createNativeQuery(sql);
		Object obj = query.getSingleResult();
		return obj == null ? 0 : Integer.valueOf(obj.toString());
	}
	
}
