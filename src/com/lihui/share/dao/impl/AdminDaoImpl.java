package com.lihui.share.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

import com.lihui.share.dao.IAdminDao;
import com.lihui.share.entity.Admin;

public class AdminDaoImpl implements IAdminDao
{
	private SqlSessionTemplate template;

	
	public SqlSessionTemplate getTemplate()
	{
		return template;
	}

	@Autowired
	public void setTemplate(SqlSessionTemplate template)
	{
		this.template = template;
	}


	@Override
	public Admin queryAdminByNameAndPwd(@Param("ad_name")String adminName, @Param("pwd")String pwd)
	{
		Admin admin = null;
		admin = template.selectOne("queryAdminByNameAndPwd");
		return admin;
	}

}
