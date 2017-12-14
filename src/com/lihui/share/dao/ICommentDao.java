package com.lihui.share.dao;

import java.util.List;

import com.lihui.share.entity.Comment;

public interface ICommentDao
{
	public void insertComment();
	
	public void updateCommentById();
	
	public void deleteCommentById();
	
	public Comment getCommentById();
	
	public List<Comment> findAllComments();
}
