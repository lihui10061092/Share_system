package com.lihui.share.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IAnnouncementDao;
import com.lihui.share.entity.Announcement;
import com.lihui.share.util.TimeStampUtil;

public class AnnounceTest extends Base
{
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertShare()
//	{
//		Map<String, Object> insertParamMap = new HashMap<String, Object>();
//		insertParamMap.put("a_title", "2017年6月18日Java技术培训22");
//		insertParamMap.put("a_content", "1.Spring入门。2.Spring进阶。3.SpringMVC开发示例。");
//		insertParamMap.put("a_date", TimeStampUtil.getCurTimeStamp());
//		insertParamMap.put("u_date", TimeStampUtil.getCurTimeStamp());
//		insertParamMap.put("isdelete", Boolean.valueOf(false));
//		
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IAnnouncementDao mapper = ac.getBean("iAnnouncementDao",IAnnouncementDao.class);
//		mapper.insertAnnounce(insertParamMap);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindAllShare()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IAnnouncementDao mapper = ac.getBean("iAnnouncementDao",IAnnouncementDao.class);
//		List<Announcement> allAnnounce = mapper.queryAllAnnounce();
//		
//		for(Announcement announce : allAnnounce)
//		{
//			logger.info(announce.toString());
//		}
//	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void testFindTitles()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IAnnouncementDao mapper = ac.getBean("iAnnouncementDao",IAnnouncementDao.class);
		List<Map> titlesMap = mapper.queryFiveTitles();
		
		for(Map<String, String> titleMap : titlesMap)
		{
			logger.info(titleMap);
		}
	}
}
