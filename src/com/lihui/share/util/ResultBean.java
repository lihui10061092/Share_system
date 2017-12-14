package com.lihui.share.util;

import java.util.Map;

public class ResultBean
{
	//
	private boolean isSuccess;
	//
	private Map<String, Object> data;
	
	public boolean isSuccess()
	{
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess)
	{
		this.isSuccess = isSuccess;
	}

	public Map<String, Object> getData()
	{
		return data;
	}

	public void setData(Map<String, Object> data)
	{
		this.data = data;
	}

	public ResultBean()
	{
		
	}
	
	public ResultBean(boolean isSuccess, Map<String, Object> dataMap)
	{
		this.isSuccess = isSuccess;
		this.data = dataMap;
	}
	
	public static ResultBean getInstance()
	{
		return new ResultBean();
	}
}
