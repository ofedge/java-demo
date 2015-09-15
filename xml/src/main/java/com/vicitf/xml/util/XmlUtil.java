package com.vicitf.xml.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlUtil {
	
	public static String rootSuffix = "s";
	
	public static String xmlHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	
	public static void listToXmlToFile(List<?> list, File file) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IOException {
		if (list == null || list.size() == 0) {
			throw new ArrayIndexOutOfBoundsException("list为空或长度为0");
		}
		Class<?> clz = list.get(0).getClass();
		String rowName = clz.getSimpleName();
		String rootName = rowName + rootSuffix;
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement(rootName);
		for (int i = 0; i < list.size(); i++) {
			Element row = root.addElement(rowName);
			Class<?> c = list.get(i).getClass();
			Field[] field = c.getDeclaredFields();
			for (Field f : field) {
				String fieldName = f.getName();
				Element ele = row.addElement(fieldName);
				String methodName = "get" + new StringBuilder().append(Character.toUpperCase(fieldName.charAt(0))).append(fieldName.substring(1));
				Method method = clz.getDeclaredMethod(methodName, null);
				String fieldValue = method.invoke(list.get(i), null).toString();
				ele.setText(fieldValue);
			}
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
		writer.write(doc);
	}
	
	public static String listToXmlToString(List<?> list) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (list == null || list.size() == 0) {
			throw new ArrayIndexOutOfBoundsException("list为空或长度为0");
		}
		StringBuffer result = new StringBuffer(xmlHead);
		Class<?> clz = list.get(0).getClass();
		String rowName = clz.getSimpleName();
		String rootName = rowName + rootSuffix;
		result.append("<").append(rootName).append(">");
		for (int i = 0; i < list.size(); i++) {
			result.append("<").append(rowName).append(">");
			Class<?> c = list.get(i).getClass();
			Field[] field = c.getDeclaredFields();
			for (Field f : field) {
				String fieldName = f.getName();
				result.append("<").append(fieldName).append(">");
				String methodName = "get" + new StringBuilder().append(Character.toUpperCase(fieldName.charAt(0))).append(fieldName.substring(1));
				Method method = clz.getDeclaredMethod(methodName, null);
				String fieldValue = method.invoke(list.get(i), null).toString();
				result.append(fieldValue);
				result.append("</").append(fieldName).append(">");
			}
			result.append("</").append(rowName).append(">");
		}
		result.append("</").append(rootName).append(">");
		return result.toString();
	}
}
