package com.example.demo.excel;

/**
 * @author     :Lilian
 * @date       :2021/9/3 9:51
 * @description:
 */
import java.math.BigDecimal;
import java.time.LocalDate;

public class OfficeNavRecord {
	LocalDate navDate;
	BigDecimal officeNav;


	public LocalDate getNavDate() {
		return navDate;
	}

	public void setNavDate(LocalDate navDate) {
		this.navDate = navDate;
	}

	public BigDecimal getOfficeNav() {
		return officeNav;
	}

	public void setOfficeNav(BigDecimal officeNav) {
		this.officeNav = officeNav;
	}

	@Override
	public String toString() {
		return "OfficeNavRecord{" +
				"navDate=" + navDate +
				", officeNav=" + officeNav +
				'}';
	}
}
