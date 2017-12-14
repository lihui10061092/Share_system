package com.lihui.share.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;

import com.lihui.share.entity.UserGrade;

@LHAnnotation("iUserGradeDao")
public interface IUserGradeDao
{
	public void insertUserGrade(@Param("u_id")int u_id, @Param("grade")double grade);
	
	public void updateUserGrade(@Param("u_id")int u_id, @Param("grade")double grade);
	
	public UserGrade findUserGradeByUid(@Param("u_id")int u_id);
	
	public List<UserGrade> findAllUserGrade();
	
	public void deleteUserGrade(@Param("u_id")int u_id);
}
