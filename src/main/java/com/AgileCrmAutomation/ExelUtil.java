package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.beust.jcommander.Parameter;

public class ExelUtil {
/*	static ExelUtil exel=new ExelUtil();
	public static void main(String[]args) throws IOException
	{
		exel.FileRead();
		exel.FileRead1();
	}
			static Workbook wb;

			public void FileRead() throws IOException  {
				//file path
				String filePath =("C:\\Users\\Admin\\LoginTestData.xlsx");
				// get file path extension
				String extension = filePath.substring(filePath.indexOf("."));
				System.out.println(extension);
				// get the control of excel file
				FileInputStream input=new FileInputStream(filePath);
				// based on the file extension, take the control of workbook
				if (extension.equals(".xlsx")) {
					wb = new XSSFWorkbook(input);
				} else {
					wb = new HSSFWorkbook(input);
				}
				// take the control of sheet using workbook 
				Sheet sheet=wb.getSheet("Login");
				// get total number of rows  from the sheet
				int totalrows=sheet.getPhysicalNumberOfRows();
				int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
				for (int i=1; i<totalrows; i++) {
					//take the control on rows based on the i value 
					Row row = sheet.getRow(i);
					for (int j=0; j<totalColumns; j++) {
						// take the control of cell using  row reference
						Cell cell = row.getCell(j);
						// get the cell value using cell reference
						String value = cell.getStringCellValue();
						System.out.println(value);
					}
				}
				wb.close();
				input.close();

			}

			public void FileRead1() throws IOException  {
				//file path
				String filePath =("C:\\Users\\Admin\\LoginTestData.xlsx");
				// get file path extension
				String extension = filePath.substring(filePath.indexOf("."));
				System.out.println(extension);
				// get the control of excel file
				FileInputStream input=new FileInputStream(filePath);
				// based on the file extension, take the control of workbook
				if (extension.equals(".xlsx")) {
					wb = new XSSFWorkbook(input);
				} else {
					wb = new HSSFWorkbook(input);
				}
				// take the control of sheet using workbook 
				Sheet sheet=wb.getSheet("Login");
				// get total number of rows  from the sheet
				int totalrows=sheet.getPhysicalNumberOfRows();
				int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
				for (int i=1; i<totalrows; i++) {
					//take the control on rows based on the i value 
					Row row = sheet.getRow(i);
					for (int j=0; j<totalColumns; j++) {
						// take the control of cell using  row reference
						Cell cell = row.getCell(j);
						// get the cell value using cell reference
						String value = cell.getStringCellValue();
						System.out.print(value+" ");
					}
					System.out.println("    ");
				}
				wb.close();
				input.close();

			}

			
}*/


					//method to get extention based  on the provided file path 
				private String getFileExtention(String filepath) {
				    String extension = filepath.substring(filepath.indexOf("."));
				  //   System.out.println(extension);	
				     return extension;
			}
				//method to get workbbok instance based on the provided file path 
				private Workbook getWorkbbokInstance(String filepath) throws IOException {
					Workbook wb;
					FileInputStream input=new FileInputStream(filepath);
					// based on the file extension, take the control of workbook
					if (getFileExtention(filepath).equals(".xlsx")) {
						wb = new XSSFWorkbook(input);
					} else {
						wb = new HSSFWorkbook(input);
					}
					return wb;
				}
				//method to get sheet reference from the the workbbok instance 
				private Sheet getSheet(String filepath,String sheetName) {
					Sheet sheet=null;
					try {
						Workbook wb=getWorkbbokInstance(filepath);
						sheet=wb.getSheet(sheetName);
					}
					catch(IOException e) {
                    e.printStackTrace();
					}
					return sheet;
				}
				//this method return the excel file data in two dimentional array that is 
				//object [][] based on provided filepath and sheetName
				//@param filepath 
				//@param sheetName
				public Object[][] getExcelData(String filepath,String sheetName){
					Sheet sheet=getSheet(filepath,sheetName);
						int totalRows=sheet.getPhysicalNumberOfRows();
						int totalcolumn=sheet.getRow(0).getPhysicalNumberOfCells();
						return getCellValue(sheet,totalRows,totalcolumn);
						
					}
				/*this method will return the value from each cell of exel file
				 * @param sheet --->this is sheet reference
				 * @param totalRows ----> total number of rows that sheet contains
				 * @param totalColumn  ----> total number of coloumns that sheet contains 	
				 */
				private Object[][] getCellValue(Sheet sheet, int totalRows, int totalcolumn) {
					Object[][] value=new Object[totalRows][totalcolumn];
					for(int i=1;i<totalRows;i++){
				//take the control on rows based on the i value
						Row row=sheet.getRow(i);
						
						for(int j=0;j< totalcolumn;j++) {
							//take the control of cell using row reference 
							Cell cell=row.getCell(j);
							CellType type=cell.getCellType();						
							switch(type)
							{
							case STRING:
								value[i][j]=cell.getStringCellValue();
								break;
							case NUMERIC:
								value[i][j]=cell.getStringCellValue();
								break;
							case BOOLEAN:
								value[i][j]=cell.getStringCellValue();
								break;
							case _NONE:
								value[i][j]=null;
								break;
							case BLANK:
								value[i][j]=null;
								break;
								default:
									value[i][j]=null;
						      	}	
							}	
						}
						return value;
				}
			
				public static void main(String[]args) throws FileNotFoundException
				{
					String filepath="C:\\Users\\Admin\\LoginTestData.xlsx";
					ExelUtil excelvalues=new ExelUtil();
					excelvalues.setDataInExcel(filepath,"LoginTestData",0,0,"mahi"); 
					Object[][] data=excelvalues.getExcelData(filepath,"Login");
					
					int rowlenght=data.length;
					int columnlength=2;
					for(int i=1;i<rowlenght-1;i++)
					{
						for(int j=0;j<columnlength;j++)
						{
							System.out.println(data[i][j]);
							
						}
						System.out.println("   ");
					}
				}
				
				
			//************************************* change***************************************************	
				
				
				
				public void setDataInExcel (String filePath, String sheetName, int rowNum, int cellNum, Object value) throws FileNotFoundException {
					
					try {
						
					Workbook wb = getWorkbbokInstance(filePath); 
					
					Sheet sheet;

					// get the sheet details if it is present in the workbook
					 if (wb.getSheet (sheetName) != null) {

					sheet= wb.getSheet(sheetName);

					} else {
					// create new sheet in the workbook 
					sheet = wb.createSheet(sheetName);
					}



					// create row if not present else get the row control
					 Row row;
					if (sheet.getRow(rowNum) != null) {
					row=sheet.getRow(rowNum);
					} else {
					row=sheet.createRow(rowNum);
					} 
					// create cell if not present else get the cell control

					Cell cell; 
					if (row.getCell(cellNum) != null) {

					cell=row.getCell(cellNum); 
					} else {

					cell=row.createCell(cellNum);
					}

					setCellValue(cell, value); 
					FileOutputStream output=new FileOutputStream(filePath);
					wb.write(output);
					 wb.close();

					}catch (IOException e) {

					e.printStackTrace();

					}
				}
				public void setCellValue(Cell cell, Object val) {

					if (val instanceof Integer) {
						cell.setCellValue((int) val);
					} else if (val instanceof String) {
						cell.setCellValue(val.toString());
					} else if (val instanceof Boolean) {
						cell.setCellValue((boolean) val);
					}
				}
				}


	


