package com.lihui.share.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihui.share.dao.IShareDao;
import com.lihui.share.dao.IUserDao;
import com.lihui.share.entity.User;
import com.lihui.share.service.IUserService;
/**
 * 
 * @author lihui
 * @Description 用户Service层
 * @date 2017年3月21日
 */
@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IShareDao shareDao;
	
	@Override
	public User findUserById(int userId)
	{
		return userDao.queryUserById(userId);
	}

	@Override
	public List<User> findAll()
	{
		List<User> userList = new ArrayList<User>();
		userList = userDao.findAll();
		return userList;
	}

	@Override
	public User findUserByLoginNameAndPwd(String loginame, String pwd)
	{
		return userDao.queryUserByLoginNameAndPwd(loginame, pwd);
	}

	@Override
	public void updateUser(Map<String, Object> updateParams)
	{
		userDao.updateUser(updateParams);
	}

	@Override
	public boolean deleteUserById(int userId)
	{
		boolean isDelete = true;
		User user = null;
		userDao.deleteUserById(userId);
		//删除用户后，该用户的分享和分享评分、论坛帖子及评论和回复都要删除
		user = this.findUserById(userId);
		//根据id查询到用户，表明删除失败
		if(null != user)
		{
			isDelete = false;
		}
		if(isDelete)
		{
			shareDao.deleteShareByUserId(userId);
			//TODO 删除该用户分享评分、论坛帖子及评论和回复
		}
		return isDelete;
	}

	@Override
	public void insertUser(Map<String, Object> addParams)
	{
//		boolean isSuccess = true;
////		User user = null;
		userDao.insertUser(addParams);
//		String longinName = (String) addParams.get("loginame");
//		String pwd = (String) addParams.get("pwd");
////		return isSuccess;
	}

	@Override
	public User findUserByLoginName(String loginame)
	{
		return userDao.queryUserByLoginName(loginame);
	}

	@Override
	public List<User> queryUserByPage(int pageIndex, int row)
	{
		int start = (pageIndex - 1) * row;
		int end = pageIndex * row;
		return userDao.queryUserByPage(start, end);
	}

	@Override
	public int queryUserCounts()
	{
		return userDao.queryUserCounts();
	}
}
