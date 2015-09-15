package com.vicitf.xml.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vicitf.xml.bean.DemoBean;
import com.vicitf.xml.service.DemoService;
import com.vicitf.xml.util.XmlUtil;

@Controller
public class IndexController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "首页");
		model.addAttribute("message", "Hello World");
		return "index";
	}
	
	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	public String list() {
		List<DemoBean> list = demoService.findAll();
		String xml = "";
		try {
			xml = XmlUtil.listToXmlToString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml;
	}
	
}
