package com.example.demo.excel;

import com.alibaba.fastjson.JSONObject;
import com.huasheng.fund.common.product.constant.RiskLevel;
import com.huasheng.fund.common.product.domain.ProductConfig;
import com.huasheng.fund.common.quotes.domain.OfficeNav;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author     :Lilian
 * @date       :2021/9/6 10:07
 * @description:
 */
public class OfficeNavLatest {
	public static void main_(String[] args) {
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

	public static void main1(String[] args) {
		String a = "2021/01/12".split("/")[1];
		System.out.println(Integer.valueOf(a));
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.of(2021,1,1), LocalTime.MIN,  ZoneId.of("Europe/Paris"));
		System.out.println(zonedDateTime);
	}
	public static void main2(String[] args) {
		LocalDate d1 = LocalDate.of(2021,11,1);
		LocalDate d2 = LocalDate.of(2021,12,1);
		LocalDate d3 = LocalDate.of(2021,01,1);
		OfficeNav a1 = new OfficeNav();
		a1.setNavDate(d1);
		OfficeNav a2 = new OfficeNav();
		a2.setNavDate(d2);
		OfficeNav a3 = new OfficeNav();
		a3.setNavDate(d3);
		List<OfficeNav> officeNavList = new ArrayList<>();
		officeNavList.add(a1);
		officeNavList.add(a2);
		officeNavList.add(a3);
		officeNavList.sort(Comparator.comparing(OfficeNav::getNavDate));
		System.out.println(officeNavList.get(0).getNavDate());
		System.out.println(officeNavList.get(1).getNavDate());
		System.out.println(officeNavList.get(2).getNavDate());
		BigDecimal aaa= new BigDecimal("1.2200");
		System.out.println(aaa.stripTrailingZeros().scale());
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		zonedDateTime = ZonedDateTime.of(zonedDateTime.toLocalDateTime(), ZoneId.of("Europe/Paris"));
		System.out.println(zonedDateTime.toLocalDateTime());

		ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));

		System.out.println(zonedDateTime1.toLocalDateTime());
		System.out.println(zonedDateTime1.toLocalDateTime().format(DateTimeFormatter.ofPattern("HHmm")));


		ZonedDateTime cutofftime = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(1900,1,1),LocalTime.of(17,30,0)), ZoneId.of("Europe/Paris"));
		System.out.println(cutofftime);
		System.out.println(cutofftime.withZoneSameInstant(ZoneId.of("Asia/Shanghai")).format(DateTimeFormatter.ofPattern("HHmm")));

		BigDecimal b = new BigDecimal(1.2222);
		b.setScale(3, RoundingMode.HALF_UP);
		System.out.println("scale");
		System.out.println("scale = " + b.scale());

		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(localDateTime.format(dateTimeFormatter));


		LocalDateTime start = LocalDate.of(2022,2,1).minusDays(1).with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN);
		LocalDateTime end = LocalDate.of(2022,2,1).minusDays(1).with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MIN);
		System.out.println(start);
		System.out.println(end);
		// 月末时间 2021/1/31 23:59:59
	}
}
