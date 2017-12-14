package com.lihui.share.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeStampUtil
{
	public static Timestamp String2TimeStamp(String tsStr)
	{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		String tsStr = "2011-05-09 11:49:45";
		try 
		{
			ts = Timestamp.valueOf(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	//获取当前的时间
	public static Timestamp getCurTimeStamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static String TimeStamp2String(Timestamp ts)
	{
		//Timestamp ts = new Timestamp(System.currentTimeMillis());
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try
		{
			tsStr = sdf.format(ts);
			//tsStr = ts.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return tsStr;
	}
}
