package com.vicitf.springdatajpa.bean;

import java.math.BigInteger;

public class ChangedTableBean {
	private Integer tableId;
	private String schemaName;
	private String tableName;
	private BigInteger changedRows;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

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

	public BigInteger getChangedRows() {
		return changedRows;
	}

	public void setChangedRows(BigInteger changedRows) {
		this.changedRows = changedRows;
	}

	@Override
	public String toString() {
		return "ChangedTableBean [tableId=" + tableId + ", schemaName="
				+ schemaName + ", tableName=" + tableName + ", changedRows="
				+ changedRows + "]";
	}
}
