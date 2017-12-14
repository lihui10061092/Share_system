package com.lihui.share.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IUserGradeDao;
import com.lihui.share.entity.UserGrade;

public class UserGradeTest extends Base
{
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertUserGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IUserGradeDao mapper = ac.getBean("iUserGradeDao", IUserGradeDao.class);
//		
//		mapper.insertUserGrade(2, 76.6);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateUserGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IUserGradeDao mapper = ac.getBean("iUserGradeDao", IUserGradeDao.class);
//		
//		mapper.updateUserGrade(2, 86.6);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateUserGrade()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IUserGradeDao mapper = ac.getBean("iUserGradeDao", IUserGradeDao.class);
//		
//		UserGrade grade = mapper.findUserGradeByUid(1);
//		logger.info(grade.toString());
//		
//	}
	
	@SuppressWarnings("resource")
	@Test
	public void testUpdateUserGrade()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IUserGradeDao mapper = ac.getBean("iUserGradeDao", IUserGradeDao.class);
		
		mapper.deleteUserGrade(2);
	}
}
