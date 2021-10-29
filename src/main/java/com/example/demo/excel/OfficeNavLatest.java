package com.example.demo.excel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @author     :Lilian
 * @date       :2021/9/6 10:07
 * @description:
 */
public class OfficeNavLatest {
	public static void main(String[] args) {
		Long productId = 22L;
		LocalDate navDate = LocalDate.of(2021, 9, 2);
		BigDecimal officeNav = new BigDecimal("20.58");
		BigDecimal preOfficeNav = new BigDecimal("20.61");

		LocalDate eightDate = LocalDate.of(2021, 8, 24);
		BigDecimal eightOfficeNav = new BigDecimal("20.25");

		Integer days = Period.between(eightDate, navDate).getDays();
		BigDecimal sevenDayIncome = officeNav.subtract(eightOfficeNav).divide(eightOfficeNav, 10, RoundingMode.HALF_UP).divide(new BigDecimal(days), 10, RoundingMode.HALF_UP).multiply(new BigDecimal(365));
		DecimalFormat decimalFormat = new DecimalFormat("###0.########");
		String record = "INSERT INTO `office_nav`( `product_id`, `pre_office_nav`, `office_nav`, `nav_date`, `seven_day_income`, `updated_date`, `created_date`, `updated_by`, `created_by`)" +
				" VALUES ( " + productId + ", " + preOfficeNav + ", " + officeNav + ", '" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + decimalFormat.format(sevenDayIncome) + ", now(),now(), 'system', 'system');";

		System.out.println(record);
		String current = "UPDATE  `office_nav_current_data` SET `nav_date` =" + navDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ",`office_nav`=" + officeNav + ", `pre_office_nav`=" + preOfficeNav + ",`seven_day_income`=" + decimalFormat.format(sevenDayIncome) + ", `updated_date`=now() WHERE product_id=" + productId + ";";
		System.out.println(current);
	}
}
