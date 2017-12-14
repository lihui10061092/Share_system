package com.lihui.share.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IShareDao;
import com.lihui.share.entity.Share;
import com.lihui.share.util.DateUtil;
import com.sun.media.jfxmedia.logging.Logger;

public class ShareTest extends Base
{
	@SuppressWarnings("resource")
	@Test
	public void testInsertShare()
	{
		Map<String, Object> insertParamMap = new HashMap<String, Object>();
		Date date = DateUtil.getCurDate();
		insertParamMap.put("type", "Java技术1");
		insertParamMap.put("subject", "Spring121");
		insertParamMap.put("content", "1.Spring入门。2.Spring进阶。3.SpringMVC开发示例。");
		insertParamMap.put("u_id", Integer.valueOf(3));
		insertParamMap.put("s_time", date);
		insertParamMap.put("attachments", "Spring核心及其应用示例.pptx,Spring Boot入门");
		insertParamMap.put("grade", Double.valueOf(9.5));
		insertParamMap.put("stu_num", Integer.valueOf(32));
		insertParamMap.put("grade_num", Integer.valueOf(21));
		insertParamMap.put("ad_grade", Integer.valueOf(8));
		
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
		mapper.insertShare(insertParamMap);
	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindAllShare()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		List<Share> allShare = mapper.findAllShare();
//		
//		for(Share share : allShare)
//		{
//			logger.info(share.getAttachements());
//			logger.info(share.toString());
//		}
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testDeleteShareById()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		mapper.deleteShareById(1);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateShare()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		Map<String, Object> updateParamMap = new HashMap<String, Object>();
//		Date date = DateUtil.getCurDate();
//		updateParamMap.put("type", "Java技术2");
//		updateParamMap.put("subject", "Spring2");
//		updateParamMap.put("content", "1.Spring入门2。2.Spring进阶2。3.SpringMVC开发示例2。");
//		updateParamMap.put("u_id", Integer.valueOf(2));
//		updateParamMap.put("s_time", date);
//		updateParamMap.put("attachments", "Spring核心及其应用示例2.ppt");
//		updateParamMap.put("grade", Double.valueOf(8.5));
//		updateParamMap.put("stu_num", Integer.valueOf(31));
//		updateParamMap.put("grade_num", Integer.valueOf(26));
//		updateParamMap.put("ad_grade", Integer.valueOf(10));
//		updateParamMap.put("s_id", Integer.valueOf(2));
//		mapper.updateShare(updateParamMap);;
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindShareById()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		Share share = mapper.findShareById(2);
//		logger.info(share.toString());
//	}
	
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateAdminGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
////		Map<String, Object> paramMap = new HashMap<String, Object>();
////		paramMap.put("ad_grade", Integer.valueOf(6));
////		paramMap.put("s_id", Integer.valueOf(3));
//		
//		mapper.updateAdminGrade(6, 2);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateShare_grade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		
//		mapper.updateShare_grade(8.8, 2);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateShare_gradeNum()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareDao mapper = ac.getBean("iShareDao",IShareDao.class);
//		
//		mapper.updateShare_gradeNum(88, 3);
//	}
}
