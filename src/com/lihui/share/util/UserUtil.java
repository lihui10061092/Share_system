package com.lihui.share.util;

import java.util.HashMap;
import java.util.Map;

import com.lihui.share.entity.User;

public class UserUtil
{
	/**
	 * 由Map信息构造用户
	 * @param userInfoMap
	 * @return
	 */
	public static User toUserbyMap(Map<String, String> userInfoMap)
	{
		User user = new User();
		user.setUser_id(Integer.parseInt(userInfoMap.get("user_id")));
		user.setLoginame(userInfoMap.get("loginame"));
		user.setName(userInfoMap.get("name"));
		user.setPwd(userInfoMap.get("pwd"));
		user.setEmp_id(userInfoMap.get("emp_id"));
		user.setEmail(userInfoMap.get("email"));
		user.setTel(userInfoMap.get("tel"));
		user.setAddr(userInfoMap.get("addr"));
		user.setCompany(userInfoMap.get("company"));
		user.setDept(userInfoMap.get("dept"));
		user.setProject(userInfoMap.get("project"));
		user.setPosition(userInfoMap.get("position"));
		user.setLevel(userInfoMap.get("level"));
		return user;
	}
	
	public static Map<String, String> toMapByUser(User user)
	{
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("user_id", user.getUser_id()+"");
		userMap.put("loginame", user.getLoginame());
		userMap.put("name", user.getName());
		userMap.put("pwd", user.getPwd());
		userMap.put("emp_id", user.getEmp_id());
		userMap.put("email", user.getEmail());
		userMap.put("tel", user.getTel());
		userMap.put("addr", user.getAddr());
		userMap.put("company", user.getCompany());
		userMap.put("dept", user.getDept());
		userMap.put("project", user.getProject());
		userMap.put("position", user.getPosition());
		userMap.put("level", user.getLevel());
		return userMap;
	}
}
