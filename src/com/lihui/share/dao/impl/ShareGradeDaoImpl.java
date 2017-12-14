package com.lihui.share.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lihui.share.dao.IShareGradeDao;
import com.lihui.share.entity.ShareGrade;
@Repository
public class ShareGradeDaoImpl implements IShareGradeDao
{
	//自动注入
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public void InserShareGrade(@Param("s_id")int s_id, @Param("u_id")int u_id, @Param("grade")int grade)
	{
		template.insert("InserShareGrade");
	}

	@Override
	public void updateShareGrade(@Param("s_id")int s_id, @Param("u_id")int u_id, @Param("grade")int grade)
	{
		template.update("updateShareGrade");
	}

	@Override
	public ShareGrade findShareGradeBySidAndUid(@Param("s_id")int s_id, @Param("u_id")int u_id)
	{
		ShareGrade grade = null;
		grade = template.selectOne("findShareGradeByUidAndSid");
		return grade;
	}

	@Override
	public List<ShareGrade> findAllShareGrade()
	{
		List<ShareGrade> grades = template.selectList("findAllShareGrade");
		return grades;
	}

	@Override
	public void deleteShareGradeBySidAndUid(@Param("s_id")int s_id, @Param("u_id")int u_id)
	{
		template.delete("deleteShareGradeBySidAndUid");
	}

	@Override
	public List<ShareGrade> findShareGradeByShareId(@Param("s_id")int s_id)
	{
		return template.selectList("findShareGradeByShareId");
	}

}
