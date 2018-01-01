package com.lihui.share.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.lihui.share.dao.IShareDao;
import com.lihui.share.entity.Share;

/**
 * 
 * @author lihui
 * @Description 分享Dao层CRUD
 * @date 2017年3月23日
 */
//@Repository
public class ShareDaoImpl implements IShareDao
{
	//TODO 使用Spring AOP进行事务管理
	//自动注入
	@Autowired
	private SqlSessionTemplate tmp;
	//注入SqlSenssionTemplate,由SqlSessionFactory提供
//	@Autowired
//	public void setTemplate(SqlSessionTemplate tmp)
//	{
//		this.tmp = tmp;
//	}
		
	@Override
	public void insertShare(Map<String, Object> insertParams)
	{
		tmp.insert("insertShare", insertParams);
	}

	@Override
	public void deleteShareById(int shareId)
	{
		tmp.delete("deleteShareById", shareId);
	}

	//更新分享
	@Override
	public void updateShare(Map<String, Object> updateParams)
	{
		tmp.update("updateShare", updateParams);
	}
	//更新分享评分人数
	@Override
	public void updateShare_gradeNum(@Param("grade_num")int grade_num, @Param("s_id")int s_id)
	{
		//参数名称要跟xml中取的名字一致
		tmp.update("updateShare_gradeNum");
	}
	//更新分享平均分
	@Override
	public void updateShare_grade(@Param("grade")double grade, @Param("s_id")int s_id)
	{
		tmp.update("updateShare_grade");
	}
	//更新分享
	@Override
	public void updateAdminGrade(@Param("ad_grade")int ad_grade, @Param("s_id")int s_id)
	{
		tmp.update("updateAdminGrade");
	}

	@Override
	public List<Share> findAllShare()
	{
		List<Share> allShare = tmp.selectList("findAllShare");
		return allShare;
	}

	@Override
	public Share findShareById(int shareId)
	{
		Share share = null;
		share = tmp.selectOne("findShareById", shareId);
		return share;
	}

	@Override
	public List<Share> findShareByPage(@Param("start")int start, @Param("end")int end)
	{
		return tmp.selectList("findShareByPage");
	}

	@Override
	public int getAllShareCounts()
	{
		return tmp.selectOne("getAllShareCounts");
	}

	@Override
	public int getMyShareCounts(int userId)
	{
		return tmp.selectOne("getMyShareCounts");
	}
//	@Override
//	public int getUserIdByShareId(int shareId)
//	{
//		// TODO Auto-generated method stub  这个方法在Service层中提供
//		return 0;
//	}

	@Override
	public List<Share> findMyShareByPage(int userId, int start, int end)
	{
		return tmp.selectList("findMyShareByPage");
	}

	@Override
	public List<Share> findOthersShareByPage(int userId, int start, int end)
	{
		return tmp.selectList("findOthersShareByPage");
	}

	@Override
	public int getOthersShareCounts(int userId)
	{
		return tmp.selectOne("getOthersShareCounts");
	}

	@Override
	public void deleteShareByUserId(int userId)
	{
		tmp.delete("deleteShareByUserId", userId);
	}

}
