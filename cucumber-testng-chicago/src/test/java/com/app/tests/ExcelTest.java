package com.app.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		File file = new File("test.xlsx");
		System.out.println(file.exists());
		
		
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook wBook = new XSSFWorkbook(input);
		XSSFSheet sheet = wBook.getSheet("Sheet3");
		XSSFRow row1 = sheet.getRow(0);
		XSSFCell cell1 = row1.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		System.out.println(cell1);
		XSSFCell cellToChange = sheet.getRow(1).getCell(3);
		System.out.println("Before: " + cellToChange);
		
		
		
		
		cellToChange.setCellValue("111222333");
		FileOutputStream output = new FileOutputStream(file);
		wBook.write(output);
		output.close();
	}
}



