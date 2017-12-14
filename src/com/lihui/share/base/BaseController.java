package com.lihui.share.base;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseController extends Base
{
	/**
	 * 将前端传来的参数封装成Map<String, Objecgt>形式
	 * @return
	 */
	public Map<String, Object> getAllParamsMap(HttpServletRequest request)
	{
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		Enumeration<?> names = request.getParameterNames();
		String[] values;
		logger.debug("URL:" + request.getRequestURL());
		if(null != names)
		{
			while(names.hasMoreElements())
			{
				String name = (String) names.nextElement();
				values = request.getParameterValues(name);
				if(null != values && values.length > 0)
				{
					if(values.length == 1)
					{
						paramsMap.put(name, values[0]);
					}
					else
					{
						paramsMap.put(name, Arrays.asList(values));
					}
				}
			}
		}
		
		return paramsMap;
	}
	
	/**
	 * 将前端传来的参数封装成Map<String, String>形式
	 * @return
	 */
	public Map<String, String> getAllParamsStringMap(HttpServletRequest request)
	{
		Map<String, String> paramsMap = new HashMap<String, String>();
		Enumeration<?> names = request.getParameterNames();
		String[] values;
		logger.debug("URL:" + request.getRequestURL());
		if(null != names)
		{
			while(names.hasMoreElements())
			{
				String name = (String) names.nextElement();
				values = request.getParameterValues(name);
				if(null != values && values.length > 0)
				{
					if(values.length == 1)
					{
						paramsMap.put(name, values[0]);
					}
					else
					{
						paramsMap.put(name, values.toString());
					}
				}
			}
		}
		
		return paramsMap;
	}
}
