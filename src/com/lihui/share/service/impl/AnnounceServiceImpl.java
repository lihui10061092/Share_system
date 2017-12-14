package com.lihui.share.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihui.share.dao.IAnnouncementDao;
import com.lihui.share.entity.Announcement;
import com.lihui.share.service.IAnnounceService;

@Service
public class AnnounceServiceImpl implements IAnnounceService
{
	@Autowired
	private IAnnouncementDao annouceDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryTitles()
	{
		return annouceDao.queryFiveTitles();
	}

	@Override
	public List<Announcement> queryAnnounce()
	{
		return annouceDao.queryAllAnnounce();
	}
}
