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
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;
	
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
	public static Date getDateValue(int i, int j, String filePath, String sheet) throws IOException
	{
		f = new FileInputStream(System.getProperty("user.dir")+ filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		Date date = c.getDateCellValue();
		//return String.valueOf(date);
		return date;
	}
	
	
	

}
