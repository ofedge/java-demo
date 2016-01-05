package com.vicitf.excel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    
	/**
	 * 要读取的表格
	 */
    public static final int SHEET_INDEX = 0;
    
    /**
     * 读取xls文件
     * 
     * @param is
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("resource")
	public static List<List<Object>> getDataFromXls(InputStream is) throws FileNotFoundException, IOException {
    	List<List<Object>> list = new ArrayList<List<Object>>();
        HSSFWorkbook wb = new HSSFWorkbook(is); // 读取文件
        HSSFSheet sheet = wb.getSheetAt(SHEET_INDEX); // 表格
        int len = sheet.getLastRowNum();
        for (int i = 0; i <= len; i++) {
            HSSFRow row = sheet.getRow(i); // 行
            List<Object> ol = new ArrayList<Object>();
            int cellLen = row.getLastCellNum();
            for (int j = 0; j <= cellLen; j++) {
				HSSFCell cell = row.getCell(j); // 单元格
				if (cell != null){
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_BOOLEAN: // 布尔值
						boolean value = cell.getBooleanCellValue();
						ol.add(value);
						break;
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						if (HSSFDateUtil.isCellDateFormatted(cell)){ //日期
							Date date = cell.getDateCellValue();
							ol.add(date);
						} else {
							double dValue = cell.getNumericCellValue();
							ol.add(formatDouble(dValue));
						}
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						String fValue = cell.getCellFormula();
						ol.add(fValue);
						break;
					case HSSFCell.CELL_TYPE_STRING: // 文本
						String sValue = cell.getRichStringCellValue().toString();
						ol.add(sValue);
						break;
					default:
						break;
					}
				}
			}
            list.add(ol);
        }
        return list;
    }
    
    /**
     * 读取xlsx文件中
     * 
     * @param is
     * @return
     * @throws IOException 
     */
    @SuppressWarnings("resource")
	public static List<List<Object>> getDataFromXlsx(InputStream is) throws IOException {
        List<List<Object>> list = new ArrayList<List<Object>>();
        XSSFWorkbook wb = new XSSFWorkbook(is); // 读取文件
        XSSFSheet sheet = wb.getSheetAt(SHEET_INDEX); //变革
        int len = sheet.getLastRowNum();
        for (int i = 0; i <= len; i++) {
            XSSFRow row = sheet.getRow(i); // 行
            List<Object> ol = new ArrayList<Object>();
            int rowLen = sheet.getLastRowNum();
            for (int j = 0; j < rowLen; j++) {
            	XSSFCell cell = row.getCell(j); // 单元格
            	if (cell != null) {
            		switch (cell.getCellType()) {
            		case XSSFCell.CELL_TYPE_BOOLEAN: // 布尔值
            			boolean value = cell.getBooleanCellValue();
            			ol.add(value);
            			break;
            		case XSSFCell.CELL_TYPE_NUMERIC: // 数字
            			if (HSSFDateUtil.isCellDateFormatted(cell)){ //日期
            				Date date = cell.getDateCellValue();
            				ol.add(date);
            			} else {
            				double dValue = cell.getNumericCellValue();
            				ol.add(formatDouble(dValue));
            			}
            			break;
            		case XSSFCell.CELL_TYPE_FORMULA: // 公式
            			String fValue = cell.getCellFormula();
            			ol.add(fValue);
            			break;
            		case XSSFCell.CELL_TYPE_STRING: // 文本
            			String sValue = cell.getRichStringCellValue().toString();
            			ol.add(sValue);
            			break;
            		default:
            			break;
            		}
            	}
			}
            list.add(ol);
        }
        return list;
    }
    
    /**
     * 获取文件后缀
     * 
     * @param filename
     * @return
     */
    public static String getFileExt(String filename) {
    	if (filename == null) {
    		return "";
    	}
        return filename.indexOf(".") == -1 ? "" : filename.split("\\.")[filename.split("\\.").length - 1];
    }
    
    /**
     * double转string
     * 比如 9.2343434E3 之类的
     * @param value
     * @return
     */
    public static String formatDouble(double value) {
        return new DecimalFormat("#").format(value);
    }
    
}