package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	private static void writedata() throws IOException {
		File f = new File(".\\Excel_datadriven\\ReadAllData_Concept.datadriven.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(input);
		wb.createSheet("StudentData").createRow(0).createCell(0).setCellValue("StudentName");
		wb.getSheet("StudentData").getRow(0).createCell(1).setCellValue("Student_ID");
		wb.getSheet("StudentData").getRow(0).createCell(2).setCellValue("Marks");
		wb.getSheet("StudentData").getRow(0).createCell(3).setCellValue("Average");
		wb.getSheet("StudentData").createRow(1).createCell(0).setCellValue("Antony");
		wb.getSheet("StudentData").getRow(1).createCell(1).setCellValue("001");
		wb.getSheet("StudentData").getRow(1).createCell(2).setCellValue("458");
		wb.getSheet("StudentData").getRow(1).createCell(3).setCellValue("87%");
		wb.getSheet("StudentData").createRow(2).createCell(0).setCellValue("Das");
		wb.getSheet("StudentData").getRow(2).createCell(1).setCellValue("002");
		wb.getSheet("StudentData").getRow(2).createCell(2).setCellValue("567");
		wb.getSheet("StudentData").getRow(2).createCell(3).setCellValue("89%");
		wb.getSheet("StudentData").createRow(3).createCell(0).setCellValue("Jose");
		wb.getSheet("StudentData").getRow(3).createCell(1).setCellValue("003");
		wb.getSheet("StudentData").getRow(3).createCell(2).setCellValue("675");
		wb.getSheet("StudentData").getRow(3).createCell(3).setCellValue("90%");
		wb.getSheet("StudentData").createRow(4).createCell(0).setCellValue("Jack");
		wb.getSheet("StudentData").getRow(4).createCell(1).setCellValue("004");
		wb.getSheet("StudentData").getRow(4).createCell(2).setCellValue("345");
		wb.getSheet("StudentData").getRow(4).createCell(3).setCellValue("60%");
		wb.getSheet("StudentData").createRow(5).createCell(0).setCellValue("Sweet");
		wb.getSheet("StudentData").getRow(5).createCell(1).setCellValue("005");
		wb.getSheet("StudentData").getRow(5).createCell(2).setCellValue("230");
		wb.getSheet("StudentData").getRow(5).createCell(3).setCellValue("47%");

		FileOutputStream Output = new FileOutputStream(f);
		wb.write(Output);

		// System.exit(0); //it terminates the program=

		System.out.println("Code Accepted");

		wb.close();

	}

	public static void main(String[] args) throws IOException {
		writedata();

	}

}
