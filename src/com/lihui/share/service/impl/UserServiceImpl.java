package com.lihui.share.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public User findUserById(int userId)
	{
		return userDao.findUserById(userId);
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
		return userDao.findUserByLoginNameAndPwd(loginame, pwd);
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
		user = this.findUserById(userId);
		//根据id查询到用户，表明删除失败
		if(null != user)
		{
			isDelete = false;
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
		return userDao.findUserByLoginName(loginame);
	}
}
