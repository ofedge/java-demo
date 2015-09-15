package com.vicitf.xml.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.xml.bean.DemoBean;
import com.vicitf.xml.domain.Demo;
import com.vicitf.xml.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository demoRepository;
	
	public List<DemoBean> findAll() {
		List<Demo> demos = demoRepository.findAll();
		List<DemoBean> list = new ArrayList<DemoBean>();
		for (Demo demo : demos) {
			DemoBean bean = new DemoBean();
			bean.setId(demo.getId());
			bean.setText(demo.getText());
			bean.setNumber(demo.getNumber());
			bean.setDate(demo.getDate());
			list.add(bean);
		}
		return list;
	}
}
