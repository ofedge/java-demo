package com.vicitf.xml.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_demo")
public class Demo {
	private Long id;
	private String text;
	private Integer number;
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", precision = 11, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "text", length = 20)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "number", precision = 9, scale = 0)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", text=" + text + ", number=" + number
				+ ", date=" + date + "]";
	}

}
