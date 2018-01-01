package com.lihui.share.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

import com.lihui.share.dao.IPostingDao;
import com.lihui.share.entity.Posting;

//@Repository
public class PostingDaoImpl implements IPostingDao
{
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public void insertPosting(Map<String, Object> paramMap)
	{
		template.insert("insertPosting", paramMap);
	}

	@Override
	public void updatePosting(Map<String, Object> paramMap)
	{
		template.update("updatePosting", paramMap);
	}

	@Override
	public Posting findPostingById(@Param("p_id")int p_id)
	{
		return template.selectOne("findPostingById");
	}

	@Override
	public List<Posting> findAllPosting()
	{
		return template.selectList("findAllPosting");
	}

	@Override
	public void deletePostingById(int p_id)
	{
		template.delete("deletePostingById");
	}

}
