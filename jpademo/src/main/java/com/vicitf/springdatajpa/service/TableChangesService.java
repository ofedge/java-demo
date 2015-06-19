package com.vicitf.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springdatajpa.domain.SchemaTables;
import com.vicitf.springdatajpa.domain.TableChanges;
import com.vicitf.springdatajpa.repository.TableChangesRepository;

@Service
public class TableChangesService {
	@Autowired
	private TableChangesRepository tcr;
	
	@Autowired
	private SchemaTablesService stc;
	@Autowired
	private DemoService ds;
	
	/**
	 * 填充变化记录表
	 */
	public List<TableChanges> fillTableChanges(int changeId) {
		List<SchemaTables> list = stc.findAll();
		List<TableChanges> tcList = null;
		if (list != null && list.size() > 0) {
			tcList = new ArrayList<TableChanges>();
			for (SchemaTables schemaTables : list) {
				TableChanges tc = new TableChanges();
				tc.setChangeId(changeId);
				tc.setTableId(schemaTables.getId());
				int totalRow = ds.findTableRows(schemaTables);
				tc.setTotalRow(totalRow);
				tcList.add(tcr.save(tc));
			}
		}
		return tcList;
	}
	
}
