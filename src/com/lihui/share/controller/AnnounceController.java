package com.lihui.share.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihui.share.base.BaseController;
import com.lihui.share.entity.Announcement;
import com.lihui.share.service.IAnnounceService;
import com.lihui.share.util.ResultBean;

@Controller
@RequestMapping("/announce")
public class AnnounceController extends BaseController
{
	@Autowired
	private IAnnounceService annouceService;
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/querytitles.do")
	public ResultBean getTitles(HttpServletRequest request, HttpServletResponse response)
	{
		ResultBean rb = ResultBean.getInstance();
		rb.setSuccess(true);
		List<Map> titles = annouceService.queryTitles();
//		int i = 1;
//		for(Map<String, String> titleMap : titles)
//		{
////			Map.Entry<String, String> entry = (Entry<String, String>) titleMap.entrySet();
//			String value = titleMap.get("a_title");
//			titleMap.clear();
//			titleMap.put("a_title" + i++, value);
//		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("result", titles);
		rb.setData(data);
		return rb;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/queryannounces.do")
	public ResultBean getAnnounces(HttpServletRequest request, HttpServletResponse response)
	{
		ResultBean rb = ResultBean.getInstance();
		List<Announcement> anns = annouceService.queryAnnounce();
		if(anns.size() == 0)
		{
			rb.setSuccess(false);
		}
		else
		{
			rb.setSuccess(true);
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("result", anns);
		rb.setData(data);
		return rb;
	}
}
