package com.lihui.share.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IShareGradeDao;
import com.lihui.share.entity.ShareGrade;

public class ShareGradeTest extends Base
{
	@SuppressWarnings("resource")
	@Test
	public void testInsertShareGrade()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
		
		mapper.InserShareGrade(3, 2, 8);
	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testSelectShareGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
//		
//		ShareGrade grade = mapper.findShareGradeBySidAndUid(2, 1);
//		logger.info(grade.toString());
//	}
	
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertShareGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
//		
//		mapper.updateShareGrade(3, 2, 2);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertShareGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
//		
//		List<ShareGrade> allGrade = mapper.findAllShareGrade();
//		for(ShareGrade grade : allGrade)
//		{
//			logger.info(grade);
//		}
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertShareGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
//		
//		List<ShareGrade> allGrade = mapper.findShareGradeByShareId(2);
//		for(ShareGrade grade : allGrade)
//		{
//			logger.info(grade);
//		}
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertShareGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IShareGradeDao mapper = ac.getBean("iShareGradeDao", IShareGradeDao.class);
//		mapper.deleteShareGradeBySidAndUid(2, 1);
//	}
}
