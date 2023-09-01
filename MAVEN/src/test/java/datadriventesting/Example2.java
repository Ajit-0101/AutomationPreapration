
package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Example2 {
	@Test
	public void excelOps() throws IOException  {
	    //Get Excel File Location
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\AppTest.xlsx");
		// required WorkBook Object
		Workbook wb=new XSSFWorkbook(fis);
		// Perform any required operation on sheet
		
	int SheetCount=	wb.getNumberOfSheets();
		System.out.println("Sheet Count:  "+SheetCount);
		//Get Each Sheet name
		for(int i=0;i<SheetCount;i++) {
			
			System.out.println(wb.getSheetName(i));
		}
		//Get Specific Sheet
			Sheet sheet= wb.getSheet("Sheet1");
			// now you can perfom opration on row
			
			int rowCount=sheet.getLastRowNum();
		System.out.println("Row Count:  "+rowCount);// Actual Row-1 (4-1=3)
		
		//get Specific row
		
		Row row=sheet.getRow(0);
		//now we can perform on cell
		int cellCountOnRow0=row.getLastCellNum();
		System.out.println(" Cell Count in Row 0:  "+cellCountOnRow0);// Get Actual Count
		// get )th cell Value
		Cell cell =row.getCell(0);
		String cell0Value=cell.getStringCellValue();
		System.out.println("Cell 0th Value:  "+cell0Value);
		System.out.println("**************Cell VAlue in Row 0****************");
		for(int i=0;i<cellCountOnRow0;i++) {
			System.out.println(row.getCell(i).getStringCellValue());
		}
		
		System.out.println("****************************************");
//		//get row2 data
//			Row row2=sheet.getRow(2);
//			for(int i=0;i<row2.getLastCellNum();i++) {
//				System.out.println(row2.getCell(i).getStringCellValue());//Cannot get a text value from a boolean cell
//			}
		//row 2 data
			Row row2=sheet.getRow(2);
			for(int i=0;i<row2.getLastCellNum();i++) {
				//check cell type
				Cell cl=row2.getCell(i);
				switch(cl.getCellType()) {
					//match required cell type to read diff type of data
					
				case Cell.CELL_TYPE_STRING:
						System.out.println(cl.getStringCellValue());
						break;
				case Cell.CELL_TYPE_BOOLEAN:
						System.out.println(cl.getBooleanCellValue());
						break;
				case Cell.CELL_TYPE_NUMERIC:
						System.out.println(cl.getNumericCellValue());
						break;
				default:
					System.out.println("Undefined value of cell");
					break;
				}
			
			}
		
		
		
	}
}