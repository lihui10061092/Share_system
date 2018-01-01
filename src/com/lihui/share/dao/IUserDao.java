package com.lihui.share.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.User;
@LHAnnotation("iUserDao")
//@Repository("iUserDao")
public interface IUserDao
{
	public User queryUserById(int userId);
	
	public List<User> findAll();
	
	public User queryUserByLoginNameAndPwd(String loginame, String pwd);
	
	public User queryUserByLoginName(String loginame);
	
	public void updateUser(Map<String, Object> updateParams);
	
	public void deleteUserById(int userId);
	
	public void insertUser(Map<String, Object> addParams);

	public List<User> queryUserByPage(@Param("start")int start, @Param("end")int end);

	public int queryUserCounts();

}
