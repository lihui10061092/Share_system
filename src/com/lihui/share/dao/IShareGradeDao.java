package com.lihui.share.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.ShareGrade;

@LHAnnotation("iShareGradeDao")
public interface IShareGradeDao
{
	public void InserShareGrade(@Param("s_id")int s_id, @Param("u_id")int u_id, @Param("grade")int grade);
	
	public void updateShareGrade(@Param("s_id")int s_id, @Param("u_id")int u_id, @Param("grade")int grade);
	
	//先查出ShareGrade再取grade，在Service层中写
	public ShareGrade findShareGradeBySidAndUid(@Param("s_id")int s_id, @Param("u_id")int u_id);
	
	//
	public List<ShareGrade> findAllShareGrade();
	
	public void deleteShareGradeBySidAndUid(@Param("s_id")int s_id, @Param("u_id")int u_id);
	
	//根据分享id查找分享的所有用户评分，用于计算分享总分及平均分，在Service层中实现该功能
	public List<ShareGrade> findShareGradeByShareId(@Param("s_id")int s_id);
	
}
