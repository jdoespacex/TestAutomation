package com.app.tests;

import com.app.utilities.ExcelUtils;

public class ExcelTest2 {

	public static void main(String[] args) {
		
		ExcelUtils.openExcelFile("test.xlsx", "Sheet3");
		String data = ExcelUtils.getCellData(6, 0);
		System.out.println("Before: " + data);
		ExcelUtils.setCellData("NewValue", 6, 0);
		String data2 = ExcelUtils.getCellData(6, 0);
		System.out.println("After: " + data2);
	}
}
