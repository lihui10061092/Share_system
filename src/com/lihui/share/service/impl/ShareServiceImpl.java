package com.lihui.share.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihui.share.dao.IShareDao;
import com.lihui.share.entity.Share;
import com.lihui.share.service.IShareService;

@Service
public class ShareServiceImpl implements IShareService
{

	@Autowired
	private IShareDao shareDao;
	
	@Override
	public List<Share> findAllShare()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Share> findShareByPage(int pageIndex, int rowsOfPage)
	{
		int start = (pageIndex - 1) * rowsOfPage;
		int end = pageIndex * rowsOfPage;
		return shareDao.findShareByPage(start, end);
	}

	@Override
	public Share findShareById(int shareId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addShare(Map<String, Object> paramMap)
	{
		shareDao.insertShare(paramMap);
	}

	@Override
	public void deleteShareById(int ShareId)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShare(Map<String, Object> paramMap)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int getAllShareCounts()
	{
		return shareDao.getAllShareCounts();
	}

	//过滤分享，从所有分享中去掉自己创建的，用于首页显示。
//	@Override
//	public List<Share> filterOthersShare(List<Share> allShares, int curUserId)
//	{
//		List<Share> filterShareList = new ArrayList<Share>();
//		for(Share share : allShares)
//		{
//			if(!(curUserId == share.getUserId()))
//			{
//				filterShareList.add(share);
//			}
//		}
//		return filterShareList;
//	}

	//过滤分享，从所有分享中去掉自己创建的，用于用户首页显示。
//	@Override
//	public List<Share> filterMyShare(List<Share> allShares, int curUserId)
//	{
//		List<Share> filterShareList = new ArrayList<Share>();
//		for(Share share : allShares)
//		{
//			if(curUserId == share.getUserId())
//			{
//				filterShareList.add(share);
//			}
//		}
//		return filterShareList;
//	}
	
	@Override
	public int getMyShareCounts(int userId)
	{
		return shareDao.getMyShareCounts(userId);
	}

	@Override
	public int getOthersShareCounts(int userId)
	{
		return shareDao.getOthersShareCounts(userId);
	}
	
	@Override
	public List<Share> findOthersShareByPage(int pageIndex, int rowsOfPage, int userId)
	{
		int start = (pageIndex - 1) * rowsOfPage;
		int end = pageIndex * rowsOfPage;
		return shareDao.findOthersShareByPage(userId, start, end);
	}

	@Override
	public List<Share> findMyShareByPage(int pageIndex, int rowsOfPage, int userId)
	{
		int start = (pageIndex - 1) * rowsOfPage;
		int end = pageIndex * rowsOfPage;
		return shareDao.findMyShareByPage(userId, start, end);
	}
	
	
}
