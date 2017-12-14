package com.lihui.share.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.lihui.share.dao.IAnnouncementDao;
import com.lihui.share.entity.Announcement;

//@Repository 接口已经有注解，此处不需要
public class AnnouncementDaoImpl implements IAnnouncementDao
{
	//注入SqlSenssionTemplate,由SqlSessionFactory提供
	@Autowired
	private SqlSessionTemplate template;
	
	//方法名与Mapper.xml中的方法名一致
	@Override
	public List<Announcement> queryAllAnnounce()
	{
		List<Announcement> allAnnounce = template.selectList("queryAllAnnounce");
		return allAnnounce;
	}
	//查询5条公告的标题，按照更新时间排序
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryFiveTitles()
	{
		List<Map> titlesMap = template.selectList("queryFiveTitles");
		return titlesMap;
	}

	@Override
	public Announcement queryAnnouceById(@Param("id")int id)
	{
		return template.selectOne("queryAnnouceById", id);
	}

	@Override
	public void insertAnnounce(Map<String, Object> insertParams)
	{
		template.insert("insertAnnounce", insertParams);
	}

	@Override
	public void updateAnnouce(Map<String, Object> updateParams)
	{
		template.update("updateAnnounce", updateParams);
	}

	@Override
	public void updateTitle(@Param("title")String title, @Param("id")int id)
	{
		template.update("updateTitle");
	}

	@Override
	public void updateContent(@Param("content")String content, @Param("id")int id)
	{
		template.update("updateContent");
	}

	@Override
	public void deleteAnnounceByid(@Param("id")int id)
	{
		template.delete("deleteAnnounceByid");
	}

}
