package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	public static String getCurrentDate()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String formatedDate = sdf.format(date);
		return formatedDate;
		
	}
	
	
	
	
	

}
