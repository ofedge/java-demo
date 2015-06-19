package com.vicitf.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springdatajpa.bean.ChangedTableBean;
import com.vicitf.springdatajpa.repository.QueryRepository;

@Service
public class QueryService {
	@Autowired
	private QueryRepository qr;
	
	public List<ChangedTableBean> getChangedTables(int oldChangesId, int newChangesId) {
		return qr.getChangedTables(oldChangesId, newChangesId);
	}
}
