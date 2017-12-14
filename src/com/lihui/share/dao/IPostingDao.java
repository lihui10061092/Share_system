package com.lihui.share.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.Posting;

@LHAnnotation("iPostingDao")
public interface IPostingDao
{
	public void insertPosting(Map<String, Object> paramMap);
	
	public void updatePosting(Map<String, Object> paramMap);
	
	public Posting findPostingById(@Param("p_id")int p_id);
	
	public List<Posting> findAllPosting();
	
	public void deletePostingById(@Param("p_id")int p_id);
	
}
