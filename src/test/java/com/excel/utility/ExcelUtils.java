package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.common.commonActions.CommonActions;

public class ExcelUtils extends CommonActions {

	private static Workbook ExcelWBook;
	private static  Sheet sheet;
	CommonActions commonActions=new CommonActions();
	//private static Cell Cell;
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

/*	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new Workbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){

			throw (e);

		}

	}*/

	public ExcelUtils(String filepath) throws InvalidFormatException {
		
		File src=new File(filepath);
		FileInputStream excelFile;
		try {
			excelFile = new FileInputStream(src);
		    ExcelWBook = WorkbookFactory.create(excelFile);//new XSSFWorkbook(excelFile);
		     sheet = ExcelWBook.getSheet("Sheet2");
		}
       catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
}
}

	public String getCellData(int RowNum, int ColNum) throws Exception{
			String cellData=sheet.getRow(RowNum).getCell(ColNum).getStringCellValue().toString();
			return cellData;
	}		

//This method is to write in the Excel cell, Row num and Col num are the parameters

/*	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}*/
}