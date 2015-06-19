package com.vicitf.springdatajpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 动作对表发生的修改记录
 * 
 * @author silcata
 *
 */
@Entity
@Table(name = "t_table_changes", schema = "test")
public class TableChanges {
	private int id;
	private int tableId;
	private int totalRow;
	private int changeId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "table_id", length = 11)
	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	@Column(name = "total_row", length = 11)
	public int getTotalRow() {
		return totalRow;
	}
	
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	@Column(name = "change_id", length = 11)
	public int getChangeId() {
		return changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	@Override
	public String toString() {
		return "TableChanges [id=" + id + ", tableId=" + tableId
				+ ", totalRow=" + totalRow + ", changeId=" + changeId + "]";
	}
}
