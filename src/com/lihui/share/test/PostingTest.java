package com.lihui.share.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IPostingDao;
import com.lihui.share.entity.Posting;

public class PostingTest extends Base
{
//	@SuppressWarnings("resource")
//	@Test
//	public void testInsertPosting()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IPostingDao mapper = ac.getBean("iPostingDao", IPostingDao.class);
//		
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("u_id", Integer.valueOf(2));
//		paramMap.put("title", "想学习Spring Boot的看过来2");
//		paramMap.put("content", "哈哈哈哈，骗人的。要学自己看教程去吧2。。。。。");
//		paramMap.put("comment_num", Integer.valueOf(50));
//		paramMap.put("isdelete", false);
//		paramMap.put("postdate", ts);
//		paramMap.put("postdate", ts);
//		
//		mapper.insertPosting(paramMap);
//		
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testUpdatePosting()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IPostingDao mapper = ac.getBean("iPostingDao", IPostingDao.class);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		paramMap.put("title", "想学习Spring Boot的看过来update");
//		paramMap.put("content", "哈哈哈哈，骗人的。要学自己看教程去吧update。。。。。");
//		paramMap.put("updatedate", ts);
//		paramMap.put("posting_id", 3);
//		
//		mapper.updatePosting(paramMap);
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindPosting()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IPostingDao mapper = ac.getBean("iPostingDao", IPostingDao.class);
//		
//		Posting post = mapper.findPostingById(1);
//		logger.info(post.toString());
//	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void testFindPosting()
//	{
//		String conf = "Share_SpringMVC.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		IPostingDao mapper = ac.getBean("iPostingDao", IPostingDao.class);
//		
//		List<Posting> postList = mapper.findAllPosting();
//		for(Posting post : postList)
//		{
//			logger.info(post.toString());
//		}
//	}
	
	@SuppressWarnings("resource")
	@Test
	public void testDeletePostingById()
	{
		String conf = "Share_SpringMVC.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		IPostingDao mapper = ac.getBean("iPostingDao", IPostingDao.class);
		
		mapper.deletePostingById(1);
	}
	
	
}
