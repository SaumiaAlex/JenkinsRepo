package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public static XSSFWorkbook wb;// handles excel file
	public static XSSFSheet sh;//handles sheets in ecel file
	public static FileInputStream f;//to get file location, java inbuilt class
	
	public static String getString(int i, int j, String filePath, String sheet) throws IOException
	{
		f = new FileInputStream(System.getProperty("user.dir")+ filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
	public static String getNumeric(int i, int j, String filePath, String sheet) throws IOException
	{
		f = new FileInputStream(System.getProperty("user.dir")+ filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}
	
	
	
	
	

}
