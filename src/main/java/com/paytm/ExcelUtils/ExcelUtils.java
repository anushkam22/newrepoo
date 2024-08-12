package com.paytm.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public String getDataFromExcel(String path, String sheetname, int no, int cellno) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(no);
		Cell cell = row.getCell(cellno);
		String data = cell.getStringCellValue();
		return data;
	}

	public void writeDataFromExcel(String path, String sheetname, int no, int cellno, Date data) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(no);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		book.close();
	}

	public int getLastRowNoFromExcel(String path, String sheetname, int no) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		int count = sheet.getLastRowNum();
		return count;
	}
}
