package com.lihui.share.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IUserDao;
import com.lihui.share.entity.User;

/**
 * 
 * @author lihui
 * @Description 用户dao层，使用mybatis进行增删查改操作。不使用mybatis也可以做
 * @date 2017年3月21日
 */
//@Repository
//@LHAnnotation
public class UserDaoImpl extends Base implements IUserDao
{
	//TODO 使用Spring AOP事务管理
	private SqlSessionTemplate tmp;
	
	@Autowired
	public void setTemplate(SqlSessionTemplate tmp)
	{
		this.tmp = tmp;
	}
	
	@Override
	public User queryUserById(int userId)
	{
		User user = null;
		user = tmp.selectOne("findUserById", userId);
		return user;
	}

	@Override
	public User queryUserByLoginNameAndPwd(String loginame, String pwd)
	{
		User user = null;
		user = tmp.selectOne(loginame, pwd);
		return user;
	}

	@Override
	public void updateUser(Map<String, Object> updateParams)
	{
		tmp.update("updateUser",updateParams);
	}

	@Override
	public void deleteUserById(int userId)
	{
//		boolean isUserDelete = true;
//		User user = null;
		tmp.delete("deleteUserById", userId);
//		user = findUserById(userId);
		//根据id查询到用户，表明删除失败
		//Dao中不要放逻辑，放在Service层中
//		if(user != null)
//		{
//			isUserDelete = false;
//		}
//		return isUserDelete;
	}

	@Override
	public void insertUser(Map<String, Object> isertParams)
	{
//		boolean insertSuccess = false;
//		String loginame = isertParams.get("loginame");
//		String pwd = isertParams.get("pwd");
		tmp.insert("insertUser", isertParams);
//		User user = null;
//		user = findUserByLoginNameAndPwd(loginame,pwd);
		//根据用户id可以查询到，表示成功插入一个用户，返回前端使用
		//Dao中不要放逻辑，放在Service层中
//		if(user != null)
//		{
//			insertSuccess = true;
//		}
//		return insertSuccess;
	}

	@Override
	public List<User> findAll()
	{
		List<User> userList = new ArrayList<User>();
		userList = tmp.selectList("findAll");
		return userList;
	}

	@Override
	public User queryUserByLoginName(String loginame)
	{
		User user = null;
		user = tmp.selectOne("findUserByLoginName", loginame);
		return user;
	}

	@Override
	public List<User> queryUserByPage(int start, int end)
	{
		List<User> userList = new ArrayList<User>();
		userList = tmp.selectList("queryUserByPage");
		return userList;
	}

	@Override
	public int queryUserCounts()
	{
		return tmp.selectOne("queryUserCounts");
	}

}
