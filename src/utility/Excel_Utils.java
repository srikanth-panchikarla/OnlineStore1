package utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;



public class Excel_Utils {

	private static XSSFSheet worksheet;
	private static XSSFWorkbook workbook;
	private static XSSFRow row;
	private static XSSFCell cell; 
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			workbook = new XSSFWorkbook(ExcelFile);

			worksheet = workbook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData1(int RowNum, int ColNum) throws Exception{

			try{

  			cell = worksheet.getRow(RowNum).getCell(ColNum);

  			String CellData = cell.getStringCellValue();

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }
    
    
    /*
	 * This method is to get row count 
	 */
	public static int getRowCount(String sName) {
		System.out.println("=======In getRowCount method========");
		worksheet = workbook.getSheet(sName);
		System.out.println("=======In getRowCount method========" + sName);
		int rowCount = worksheet.getLastRowNum() + 1;
		System.out.println("In getrowcount method");
		return rowCount;
	}

	/*
	 * This method is to get column count 
	 */
	public static int getcolCount(String sName) {
		System.out.println("=======In getcolCount method========");
		worksheet = workbook.getSheet(sName);
		row = worksheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("In getColcount method");
		return colCount;
	}
	
	
	
	public static String getCellData(String SheetName, int ColNum, int RowNum) throws Exception {
		try {
			System.out.println("=======In getdatacell method========");
			worksheet = workbook.getSheet(SheetName);
			row = worksheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell.getCellType() == CellType.STRING)

				return cell.getStringCellValue();

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("dd/MM/YY");
					Date date = (Date) cell.getDateCellValue();
					cellValue = dt.format(date);

				}
				return cellValue;

			} else if (cell.getCellType() == CellType.BLANK)
				return " ";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "Not found";
		}

	}
  //This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			row  = worksheet.getRow(RowNum);

			cell = row.getCell(ColNum,MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				cell = row.createCell(ColNum);

				cell.setCellValue(Result);

				} else {

					cell.setCellValue(Result);

				}

  // Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(Constant.filePath_TestData + Constant.file_TestData);

  				workbook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}
	
}
