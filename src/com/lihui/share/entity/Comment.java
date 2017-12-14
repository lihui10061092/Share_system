package com.lihui.share.entity;

import java.sql.Timestamp;

public class Comment
{
	//评论或回复id
	private int commentId;
	//用户id
	private int userId;
	//所评论帖子id
	private int postingId;
	//如果是回复，表示父级评论id
	private int pCommentId;
	//评论或回复内容
	private String content;
	//是否删除，如果删除则不在页面上显示
	private boolean isDelete;
	//评论或回复时间
	private Timestamp commentDate;
	
	public Comment()
	{}

	public Comment(int commentId, int userId, int postingId, int pCommentId, String content, boolean isDelete,
			Timestamp commentDate)
	{
		this.commentId = commentId;
		this.userId = userId;
		this.postingId = postingId;
		this.pCommentId = pCommentId;
		this.content = content;
		this.isDelete = isDelete;
		this.commentDate = commentDate;
	}

	public int getCommentId()
	{
		return commentId;
	}

	public void setCommentId(int commentId)
	{
		this.commentId = commentId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getPostingId()
	{
		return postingId;
	}

	public void setPostingId(int postingId)
	{
		this.postingId = postingId;
	}

	public int getpCommentId()
	{
		return pCommentId;
	}

	public void setpCommentId(int pCommentId)
	{
		this.pCommentId = pCommentId;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public boolean isDelete()
	{
		return isDelete;
	}

	public void setDelete(boolean isDelete)
	{
		this.isDelete = isDelete;
	}

	public Timestamp getCommentDate()
	{
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate)
	{
		this.commentDate = commentDate;
	}

	@Override
	public String toString()
	{
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", postingId=" + postingId + ", pCommentId="
				+ pCommentId + ", content=" + content + ", isDelete=" + isDelete + ", commentDate=" + commentDate + "]";
	}
	
}
