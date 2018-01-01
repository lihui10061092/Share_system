package com.lihui.share.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

import com.lihui.share.dao.IUserGradeDao;
import com.lihui.share.entity.UserGrade;

//@Repository
public class UserGradeImpl implements IUserGradeDao
{
	@Autowired
	SqlSessionTemplate template;
	
	@Override
	public void insertUserGrade(@Param("u_id")int u_id, @Param("grade")double grade)
	{
		template.insert("insertUserGrade");
	}

	@Override
	public void updateUserGrade(@Param("u_id")int u_id, @Param("grade")double grade)
	{
		template.update("updateUserGrade");
	}

	@Override
	public UserGrade findUserGradeByUid(@Param("u_id")int u_id)
	{
		return template.selectOne("findUserGradeByUid");
	}

	@Override
	public List<UserGrade> findAllUserGrade()
	{
		return template.selectList("findAllUserGrade");
	}

	@Override
	public void deleteUserGrade(@Param("u_id")int u_id)
	{
		template.delete("deleteUserGradeByUid");
	}

}
