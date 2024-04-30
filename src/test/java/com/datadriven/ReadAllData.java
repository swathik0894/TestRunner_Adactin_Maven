package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllData {

	private static void readall_Data() throws IOException {
		File f = new File(
				"C:\\Java_workspace\\Eclipse\\MavenProject\\Excel_datadriven\\ReadAllData_Concept.datadriven.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(input);
		Sheet sheetAt = wb.getSheetAt(0);

		int NumberOfRows = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < NumberOfRows; i++) {
			Row row = sheetAt.getRow(i);

			int NumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < NumberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				if (cellType.equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}

				else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					int data= (int) numericCellValue;
					System.out.println(data);

				}

			}

		}
		wb.close();

	}

	public static void main(String[] args) throws IOException {

		readall_Data();

	}

}
