package com.vicitf.springdatajpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 存放所有表, 不包含test, mysql, information_schema数据库, 添加之后不要变更内容
 * 
 * @author silcata
 *
 */
@Entity
@Table(name = "t_schema_tables", schema = "test")
public class SchemaTables {
	private int id;
	private String schemaName;
	private String tableName;
	
	public SchemaTables() {
	}

	/**
	 * @param schemaName 数据库名
	 * @param tableName 表名
	 */
	public SchemaTables(String schemaName, String tableName) {
		this.schemaName = schemaName;
		this.tableName = tableName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "schema_name", length = 50)
	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "SchemaTables [id=" + id + ", schemaName=" + schemaName
				+ ", tableName=" + tableName + "]";
	}
}
