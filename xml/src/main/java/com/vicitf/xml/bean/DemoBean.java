package com.vicitf.xml.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoBean {
	private Long id;
	private String text;
	private Integer number;
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date == null ? "" : new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(date);
	}

	@Override
	public String toString() {
		return "DemoBean [id=" + id + ", text=" + text + ", number=" + number
				+ ", date=" + date + "]";
	}
}
