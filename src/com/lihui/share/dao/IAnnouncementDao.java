package com.lihui.share.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.Announcement;
@LHAnnotation(value="iAnnouncementDao")
public interface IAnnouncementDao
{
	public List<Announcement> queryAllAnnounce();
	
	@SuppressWarnings("rawtypes")
	public List<Map> queryFiveTitles();
	
	public Announcement queryAnnouceById(@Param("id")int id);
	
	public void insertAnnounce(Map<String, Object> insertParams);
	
	public void updateAnnouce(Map<String, Object> updateParams);
	
	public void updateTitle(@Param("title")String title, @Param("id")int id);
	
	public void updateContent(@Param("content")String content, @Param("id")int id);
	
	public void deleteAnnounceByid(@Param("id")int id);
}
