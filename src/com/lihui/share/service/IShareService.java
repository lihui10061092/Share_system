package com.lihui.share.service;

import java.util.List;
import java.util.Map;

import com.lihui.share.entity.Share;

public interface IShareService
{
	public List<Share> findAllShare();
	
	public List<Share> findShareByPage(int pageIndex, int rowsOfPage);
	
	public Share findShareById(int shareId);
	
	public void addShare(Map<String, Object> paramMap);
	
	public void deleteShareById(int ShareId);
	
	public void updateShare(Map<String, Object> paramMap);
	
	public int getAllShareCounts();

//	public List<Share> filterOthersShare(List<Share> allShares, int curUserId);
//	
//	public List<Share> filterMyShare(List<Share> allShares, int curUserId);

	public int getMyShareCounts(int userId);
	
	public int getOthersShareCounts(int userId);
	
	public List<Share> findOthersShareByPage(int pageIndex, int rowsOfPage, int userId);
	
	public List<Share> findMyShareByPage(int pageIndex, int rowsOfPage, int userId);
}
