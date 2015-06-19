package com.vicitf.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springdatajpa.domain.Changes;
import com.vicitf.springdatajpa.domain.TableChanges;
import com.vicitf.springdatajpa.repository.ChangeRepository;

@Service
public class ChangeService {
	@Autowired
	private ChangeRepository cr;
	
	@Autowired
	private TableChangesService tcs;
	
	/**
	 * 一个新的动作
	 * 
	 * @param changes
	 * @return
	 */
	public List<TableChanges> newChange(Changes changes) {
		Changes c = cr.save(changes);
		int changeId = c.getId();
		return tcs.fillTableChanges(changeId);
	}
}
