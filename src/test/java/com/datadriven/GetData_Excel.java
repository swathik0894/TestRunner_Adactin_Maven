package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData_Excel {
	
	private static void ReadData() throws IOException {
		//File f=new File("C:\\Java_workspace\\Eclipse\\MavenProject\\Excel_datadriven\\Excel_Wroksheet_datadriven.xlsx");
		File f=new File(".\\Excel_datadriven\\Excel_Wroksheet_datadriven.xlsx");  //we can use this method as well for the path by using '.' 

		FileInputStream read_Data=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(read_Data);   //UpCasting 
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(2);
		Cell cell = row.getCell(2);
		CellType cellType = cell.getCellType();
		
		if (cellType.equals(cellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			
		}
		else if (cellType.equals(cellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data=(int) numericCellValue;
			System.out.println(data);
			
		}
		
		wb.close();
	}
	
	
//	private static void WriteData() throws IOException {
//		
//		File f1=new File("C:\\\\Java_workspace\\\\Eclipse\\\\MavenProject\\\\Excel_datadriven\\\\Excel_Wroksheet_datadriven.xlsx");
//		FileInputStream write_Data= new FileInputStream(f1);
//		Workbook w=new XSSFWorkbook(write_Data);
//		Sheet sheet = w.createSheet("datadriven");
//		Row row = sheet.createRow(0);
//		Cell cell = row.createCell(1);
//		 cell.setCellValue("3No's");
//		
//
//	}

	public static void main(String[] args) throws IOException {
		ReadData();
//		WriteData();
		
		
	}

}
