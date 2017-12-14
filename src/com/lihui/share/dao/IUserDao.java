package com.lihui.share.dao;

import java.util.List;
import java.util.Map;


import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.User;
@LHAnnotation("iUserDao")
//@Repository("iUserDao")
public interface IUserDao
{
	public User findUserById(int userId);
	
	public List<User> findAll();
	
	public User findUserByLoginNameAndPwd(String loginame, String pwd);
	
	public User findUserByLoginName(String loginame);
	
	public void updateUser(Map<String, Object> updateParams);
	
	public void deleteUserById(int userId);
	
	public void insertUser(Map<String, Object> addParams);

}
