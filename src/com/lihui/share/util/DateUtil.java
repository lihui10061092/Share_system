package com.lihui.share.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
	//JDK日期格式
	private final static String jdkDateFormat = "yyyy-MM-dd";

	// JDK时间格式
	private final static String jdkDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	public final static SimpleDateFormat df = new SimpleDateFormat(jdkDateTimeFormat);
	
	public static Date getCurDate()
	{
		Date date = strToDate(df.format(new Date()));
		return date;
	}
	
	// String转日期
	public static Date strToDate(String strDate)
	{ 
		SimpleDateFormat dateFormat = new SimpleDateFormat(jdkDateFormat); 
		Date date = null; 
		try
		{ 
			date = dateFormat.parse(strDate); 
		}
		catch(ParseException e)
		{ 
			System.out.println(e.getMessage()); 
		} 
		return date; 
	}

	// 
	public static Date strToDateTime(String strDateTime)
	{ 
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(jdkDateTimeFormat); 
		Date dateTime = null; 
		try
		{ 
			dateTime = dateTimeFormat.parse(strDateTime); 
		}catch(ParseException e)
		{ 
			System.out.println(e.getMessage()); 
		}	 
		return dateTime; 
	}

	// 
	public static String dateToStr(Date date)
	{ 
		SimpleDateFormat dateFormat = new SimpleDateFormat(jdkDateFormat); 
		String strDate = dateFormat.format(date); 
		return strDate; 
	}

	// dateTime转换String
	public static String dateTimeToStr(Date date)
	{ 
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(jdkDateTimeFormat); 
		String strDateTime = dateTimeFormat.format(date); 
		return strDateTime; 
	}
}
