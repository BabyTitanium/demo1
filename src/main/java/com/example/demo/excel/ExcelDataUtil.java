package com.example.demo.excel;

import com.example.demo.excel.OfficeNavRecord;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelDataUtil {
	public static void main(String[] args) {
		try {
			String fileName = "F:\\fund\\大成基金\\大成基金\\20_25\\25_519022.txt"; //存储文件地址
			String sheetName = "25_519022";  //sheet名称
			Long productId = 25L;  //产品id
			Integer rowStartNum = 1;  //起始行号从0开始
			Integer navDateColNum = 0;  //净值日期列 从0开始
			Integer navValueColNum = 1; //净值列
			List<OfficeNavRecord> officeNavRecordList = redExcel("F:\\fund\\大成基金\\大成20_25.xlsx", sheetName, rowStartNum, navDateColNum, navValueColNum);
			transferListToInsert(officeNavRecordList, productId, fileName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 读取excel内容
	 * <p>
	 * 用户模式下：
	 * 弊端：对于少量的数据可以，单数对于大量的数据，会造成内存占据过大，有时候会造成内存溢出
	 * 建议修改成事件模式
	 */
	public static List<OfficeNavRecord> redExcel(String filePath, String sheetName, Integer rowStartNum, Integer navDateColNum, Integer navValueColNum) throws Exception {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("文件不存在!");
		}
		InputStream in = new FileInputStream(file);

		// 读取整个Excel
		XSSFWorkbook sheets = new XSSFWorkbook(in);
		// 获取第一个表单Sheet
		XSSFSheet sheetAt = sheets.getSheet(sheetName);
		//;sheets.getSheetAt(sheetNum - 1);
		ArrayList<OfficeNavRecord> list = new ArrayList<>();
		for (int i = rowStartNum; i < sheetAt.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheetAt.getRow(i);
			OfficeNavRecord officeNavRecord = new OfficeNavRecord();
			String navDateStr = getString(row.getCell(navDateColNum));
			String offNavStr = getString(row.getCell(navValueColNum));
			officeNavRecord.setNavDate(LocalDate.parse(navDateStr));
			officeNavRecord.setOfficeNav(new BigDecimal(offNavStr));
			list.add(officeNavRecord);
		}

		return list;
	}

	public static void transferListToInsert(List<OfficeNavRecord> officeNavRecordList, Long productId, String fileName) throws IOException {

		Integer length = officeNavRecordList.size();
		FileWriter fileWriter = new FileWriter(fileName);
		for (int i = 0; i < length; i++) {
			OfficeNavRecord officeNavRecord = officeNavRecordList.get(i);
			LocalDate navDate = officeNavRecord.getNavDate();
			BigDecimal offNav = officeNavRecord.getOfficeNav();
			BigDecimal preOffNav = offNav;
			BigDecimal sevenDayIncome = BigDecimal.ZERO.setScale(0);
			DecimalFormat decimalFormat = new DecimalFormat("###0.########");
			if (i <= length - 2) {
				preOffNav = officeNavRecordList.get(i + 1).getOfficeNav();
			}
			if (i <= length - 8) {
				OfficeNavRecord eightRecord = officeNavRecordList.get(i + 7);
				LocalDate eightDate = eightRecord.getNavDate();
				BigDecimal eightOfficeNav = eightRecord.getOfficeNav();
				Integer days = Period.between(eightDate, navDate).getDays();
				sevenDayIncome = offNav.subtract(eightOfficeNav).divide(eightOfficeNav, 10, RoundingMode.HALF_UP).divide(new BigDecimal(days), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(365));
			}
			String record = "INSERT INTO `office_nav`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
					" VALUES ( " + productId + ", " + preOffNav + ", " + offNav + ", '" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(sevenDayIncome) + ", now(),now(), 'system', 'system');\n";
			fileWriter.append(record);
			System.out.println(record);
			if (i == 0) {
				String current = "INSERT INTO `office_nav_current_data`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
						" VALUES ( " + productId + ", " + preOffNav + ", " + offNav + ", '" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(sevenDayIncome) + ", now(),now(), 'system', 'system');\n";
				fileWriter.append(current);
				System.out.println(current);
			}
		}
		fileWriter.close();

	}

	/**
	 * 把单元格的内容转为字符串
	 *
	 * @param xssfCell 单元格
	 * @return String
	 */
	public static String getString(XSSFCell xssfCell) {
		if (xssfCell == null) {
			return "";
		}
		if (xssfCell.getCellTypeEnum() == CellType.NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
				Date date = xssfCell.getDateCellValue();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				return formatter.format(date);
			} else {
				return String.valueOf(xssfCell.getNumericCellValue());
			}
		} else if (xssfCell.getCellTypeEnum() == CellType.BOOLEAN) {
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else {
			return xssfCell.getStringCellValue();
		}
	}

}
