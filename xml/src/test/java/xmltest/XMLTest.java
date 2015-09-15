package xmltest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLTest {
	
	public static String XML_FILE = "books.xml";
	
	public void readByList() throws DocumentException {
		System.out.println("list 遍历树");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(this.getClass().getResourceAsStream(XMLTest.XML_FILE));
		Element root = doc.getRootElement();
		List<Element> childEle = root.elements();
		for (Element child : childEle) {
			List<Attribute> attrList = child.attributes();
			for (Attribute attr : attrList) {
				System.out.println(attr.getName() + ": " + attr.getValue());
			}
			List<Element> eleList = child.elements();
			for (Element ele : eleList) {
				System.out.println(ele.getName() + ": " + ele.getText());
			}
		}
	}
	
	public void readByIterator() throws DocumentException {
		System.out.println("iterator方式遍历");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(this.getClass().getResourceAsStream(XMLTest.XML_FILE));
		Element root = doc.getRootElement();
		Iterator it = root.elementIterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			Iterator attrIt = element.attributeIterator();
			while (attrIt.hasNext()) {
				Attribute attr = (Attribute) attrIt.next();
				System.out.println(attr.getName() + ": " + attr.getValue());
			}
			Iterator eleIt = element.elementIterator();
			while (eleIt.hasNext()) {
				Element ele = (Element) eleIt.next();
				System.out.println(ele.getName() + ": " + ele.getText());
			}
		}
	}
	
	public void createXML() throws IOException {
		Document doc = DocumentHelper.createDocument();
		Element books = doc.addElement("books");
		// book1
		Element book1 = books.addElement("book");
		book1.addAttribute("id", "001");
		Element title1 = book1.addElement("title");
		title1.setText("Harry Potter");
		Element author1 = book1.addElement("author");
		author1.setText("J K. Rowling");
		// book2
		Element book2 = books.addElement("book");
		book2.addAttribute("id", "002");
		Element title2 = book2.addElement("title");
		title2.setText("Learning XML");
		Element author2 = book2.addElement("author");
		author2.setText("Erik T. Ray");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		File file = new File("D:" + File.separator + "books.xml");
		XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
		writer.write(doc);
	}
	
	public static void main(String[] args) {
		XMLTest util = new XMLTest();
		try {
			util.createXML();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
