package xmltest;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.xml.Application;
import com.vicitf.xml.bean.DemoBean;
import com.vicitf.xml.service.DemoService;
import com.vicitf.xml.util.XmlUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class XmlUtilTest {
	
	@Autowired
	private DemoService demoService;
	
	@Test
	public void utilToFileTest() {
		List<DemoBean> list = demoService.findAll();
		try {
			XmlUtil.listToXmlToFile(list, new File("d:" + File.separator + "file.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void utilToStringTest() {
		List<DemoBean> list = demoService.findAll();
		try {
			String xml = XmlUtil.listToXmlToString(list);
			System.err.println(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
