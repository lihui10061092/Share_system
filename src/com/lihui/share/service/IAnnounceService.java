package com.lihui.share.service;

import java.util.List;
import java.util.Map;

import com.lihui.share.entity.Announcement;

public interface IAnnounceService
{
	@SuppressWarnings("rawtypes")
	public List<Map> queryTitles();
	
	public List<Announcement> queryAnnounce();
}
