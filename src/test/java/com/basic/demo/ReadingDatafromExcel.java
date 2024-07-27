package com.basic.demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel File --> Workbook --> Sheets --> Rows --> Cells




public class ReadingDatafromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testData\\Data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int totalrows = sheet.getLastRowNum();
		
		int totalcells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("No of Rows :"+totalrows);  // rows counting from 0
		System.out.println("No of Columns :"+totalcells);  // cells counting from 1
		
		
		for(int r=0;r<=totalrows;r++)
		{
			
			XSSFRow currentrow = sheet.getRow(r);
			
			for(int c=0;c<totalcells;c++)  // in java cell start from 0 thats why not using =
			{
				XSSFCell cell = currentrow.getCell(c);
				System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}

}
