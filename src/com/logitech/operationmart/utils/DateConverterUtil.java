package com.logitech.operationmart.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverterUtil {

	@SuppressWarnings("unused")
	public static Date getYesterdayDate() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date retValue = null; 
		try {
			retValue = sdf.parse(
					Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-"
							+ Calendar.getInstance().get(Calendar.DATE - 1));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return retValue;
	}

	@SuppressWarnings("unused")
	public static Date getDateFromString(String str)  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date retValue = null; 
		try {
			retValue = sdf.parse(str);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return retValue;
	}
	
	@SuppressWarnings("unused")
	public static String getStringFromDate(java.sql.Date sqlDate)   {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String retValue = null; 
		return sdf.format(sqlDate);
	}
}
