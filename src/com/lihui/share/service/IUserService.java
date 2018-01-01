package com.lihui.share.service;

import java.util.List;
import java.util.Map;


import com.lihui.share.entity.User;

public interface IUserService
{
	public User findUserById(int userId);
	
	public List<User> findAll();
	
	public User findUserByLoginNameAndPwd(String loginame, String pwd);
	
	public User findUserByLoginName(String loginame);
	
	public void updateUser(Map<String, Object> updateParams);
	
	public boolean deleteUserById(int userId);
	
	public void insertUser(Map<String, Object> addParams);

	public List<User> queryUserByPage(int pageIndex, int row);

	public int queryUserCounts();
}
