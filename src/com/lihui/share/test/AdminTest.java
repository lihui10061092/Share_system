package com.lihui.share.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IAdminDao;
import com.lihui.share.entity.Admin;

public class AdminTest extends Base
{
	@SuppressWarnings("resource")
	@Test
	public void testFindAdmin()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IAdminDao mapper = ac.getBean("iAdminDao", IAdminDao.class);
		
		Admin admin = mapper.queryAdminByNameAndPwd("admin", "admin");
		logger.info(admin.toString());
	}
}
