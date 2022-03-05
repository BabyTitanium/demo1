package com.example.demo.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.excel.OfficeNavRecord;
import org.apache.commons.lang3.StringUtils;
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
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelDataUtil {
	public static void main(String[] args) {
		try {
			String fileName = "F:\\fund\\净值\\HK0000301918.txt"; //存储文件地址
			String excelName = "F:\\fund\\净值\\【HK0000301918】NAV of Aisa Bond Fund.xlsx";
			String sheetName = "Sheet1";  //sheet名称
			Long productId = 32L;  //产品id
			Integer rowStartNum = 7;  //起始行号从0开始
			Integer navDateColNum = 0;  //净值日期列 从0开始
			Integer navValueColNum = 1; //净值列
			Integer fundClass = 1;
			String seriesNo = "0";
			List<OfficeNavRecord> officeNavRecordList = redExcel(excelName, sheetName, rowStartNum, navDateColNum, navValueColNum);
			transferListToInsert(officeNavRecordList, productId, fundClass, seriesNo, fileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		System.out.println( sheetAt.getPhysicalNumberOfRows());
		for (int i = rowStartNum; i <= sheetAt.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheetAt.getRow(i);
			OfficeNavRecord officeNavRecord = new OfficeNavRecord();
			String navDateStr = getString(row.getCell(navDateColNum));
			if (StringUtils.isBlank(navDateStr)) {
				break;
			}
			String offNavStr = getString(row.getCell(navValueColNum));
			officeNavRecord.setNavDate(LocalDate.parse(navDateStr));
			officeNavRecord.setOfficeNav(new BigDecimal(offNavStr));
			list.add(officeNavRecord);
		}

		return list;
	}

	/**
	 * INSERT INTO `hs_fund`.`office_nav`(`id`, `fund_class`, `series_no`, `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`) VALUES (30890, 1, '0', 653, 10.007400, 10.007900, '2020-04-29', 0.018649, '2020-08-25 16:25:47', '2020-08-25 16:25:47', 'system', 'system');
	 * @param officeNavRecordList
	 * @param productId
	 * @param fileName
	 * @throws IOException
	 */

	public static void transferListToInsert(List<OfficeNavRecord> officeNavRecordList, Long productId, Integer fundClass, String seriesNo, String fileName) throws IOException {
		Integer length = officeNavRecordList.size();
		FileWriter fileWriter = new FileWriter(fileName);
		officeNavRecordList.sort((o1, o2) -> o2.getNavDate().compareTo(o1.getNavDate()));
		System.out.println(officeNavRecordList.get(0).getNavDate());
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
			String record = "INSERT INTO `office_nav`(`fund_class`, `series_no`, `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
					" VALUES ( " + fundClass + ", '" + seriesNo +"', " + productId + ", " + preOffNav + ", " + offNav + ", '" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(sevenDayIncome) + ", now(),now(), 'system', 'system');\n";
			fileWriter.append(record);
			System.out.println(navDate  + "   " + offNav);
			if (i == 0) {
				String current = "INSERT INTO `office_nav_current_data`(`fund_class`, `series_no`, `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
						" VALUES ( " + fundClass + ", '" + seriesNo +"', " + productId + ", " + preOffNav + ", " + offNav + ", '" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(sevenDayIncome) + ", now(),now(), 'system', 'system');\n";
				fileWriter.append(current);
//				System.out.println(current);
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

	public static void main1(String[] args) {
		int type = 1;
		int types = type = type | 8192;
		System.out.println(types);
	}

	private static int queryQuarter(LocalDate date) {
		if(date.isBefore(date.with(Month.APRIL).withDayOfMonth(1))) {
			return 1;
		} else if(date.isBefore(date.with(Month.JULY).withDayOfMonth(1))) {
			return 2;
		} else if(date.isBefore(date.with(Month.NOVEMBER).withDayOfMonth(1))) {
			return 3;
		} else {
			return 4;
		}
	}

}
