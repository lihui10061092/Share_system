package com.lihui.share.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IUserDao;
import com.lihui.share.dao.impl.UserDaoImpl;
import com.lihui.share.entity.User;
import com.lihui.share.util.DateUtil;

public class UserTest extends Base
{
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindUserById()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IUserDao mapper = ac.getBean("userDaoImpl", UserDaoImpl.class);
//		User user = mapper.findUserById(1);
//		
//		logger.info(user.toString());
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindAllUser()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IUserDao mapper = ac.getBean("userDaoImpl", UserDaoImpl.class);
//		List<User> users = mapper.findAll();
//		for(User user : users)
//		{
//			logger.info(user.toString());
//		}
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindUserLoginNameAndPwd()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		//Mapper要定义成接口，否则多个参数查询会报错
//		IUserDao mapper = ac.getBean("iUserDao", IUserDao.class);
//		User user = mapper.findUserByLoginNameAndPwd("lihui10061092", "lwx@248053");
//		
//		logger.info(user.toString());
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindUserLoginNameAndPwd()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		//Mapper要定义成接口，否则多个参数查询会报错
//		IUserDao mapper = ac.getBean("iUserDao", IUserDao.class);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("loginame", "lihui10061092");
//		paramMap.put("name", "Lihui");
//		paramMap.put("emp_id", "lwx2480531");
//		paramMap.put("pwd", "lwx@248053");
//		paramMap.put("email", "lihui12@huawei.com");
//		paramMap.put("tel", "132022992268");
//		paramMap.put("addr", "黄金山社区5巷");
//		paramMap.put("company", "Elead");
//		paramMap.put("dept", "PLM");
//		paramMap.put("project", "PLM-PMS");
//		paramMap.put("position", "Manager");
//		paramMap.put("level", "12A");
//		mapper.updateUser(paramMap);
//	}
	
	@SuppressWarnings("resource")
	@Test
	public void testInsertUser()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		//Mapper要定义成接口，否则多个参数查询会报错
		IUserDao mapper = ac.getBean("iUserDao", IUserDao.class);
		Date hireDate = DateUtil.strToDate("2017-06-30");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginame", "Katharine2");
		paramMap.put("name", "Katharine2");
		paramMap.put("sex", "F");
		paramMap.put("emp_id", "k002480532");
		paramMap.put("pwd", "ktr@248053");
		paramMap.put("email", "Katharine2@huawei.com");
		paramMap.put("tel", "132022992299");
		paramMap.put("addr", "信义嘉御山5座");
		paramMap.put("company", "HW");
		paramMap.put("dept", "PLM2");
		paramMap.put("project", "PLM-PMS2");
		paramMap.put("position", "Manager2");
		paramMap.put("level", "16A");
		paramMap.put("hiredate", hireDate);
		mapper.insertUser(paramMap);
	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdateUser()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		//Mapper要定义成接口，否则多个参数查询会报错
//		IUserDao mapper = ac.getBean("iUserDao", IUserDao.class);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("loginame", "Katharine_u");
//		paramMap.put("name", "Katharine_u");
//		paramMap.put("emp_id", "k00248053_u");
//		paramMap.put("pwd", "ktr@248053_u");
//		paramMap.put("email", "Katharine@huawei.com");
//		paramMap.put("tel", "132022992298");
//		paramMap.put("addr", "信义嘉御山8座");
//		paramMap.put("company", "HW");
//		paramMap.put("dept", "PLM3");
//		paramMap.put("project", "PLM-PMS3");
//		paramMap.put("position", "Manager");
//		paramMap.put("level", "19A");
//		paramMap.put("user_id", Integer.valueOf(4));
//		
//		mapper.updateUser(paramMap);
//	}
}
