package com.vicitf.springdatajpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 所做过的动作
 * 
 * @author silcata
 *
 */
@Entity
@Table(name = "t_changes", schema = "test")
public class Changes {
	private int id;
	private int changeNums;
	private String changeAction;
	private Date changeTime;
	private String changedTables;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "change_nums", length = 11)
	public int getChangeNums() {
		return changeNums;
	}

	public void setChangeNums(int changeNums) {
		this.changeNums = changeNums;
	}

	@Column(name = "change_action", length = 50)
	public String getChangeAction() {
		return changeAction;
	}

	public void setChangeAction(String changeAction) {
		this.changeAction = changeAction;
	}

	@Column(name = "change_time")
	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	
	@Column(name = "changed_tables", length = 1000)
	public String getChangedTables() {
		return changedTables;
	}

	public void setChangedTables(String changedTables) {
		this.changedTables = changedTables;
	}

	@Override
	public String toString() {
		return "Changes [id=" + id + ", changeNums=" + changeNums
				+ ", changeAction=" + changeAction + ", changeTime="
				+ changeTime + ", changedTables=" + changedTables + "]";
	}

}
