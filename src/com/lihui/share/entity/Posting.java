package com.lihui.share.entity;

import java.sql.Timestamp;

public class Posting
{
	//帖子id
	private int postingId;
	//发帖人id
	private int userId;
	//标题
	private String title;
	//内容
	private String content;
	
	//评论数
	private int commentNum;
	//是否删除
	private boolean isdelete;
	//发表日期
	private Timestamp postDate;
	//更新时间
	private Timestamp updateDate;

	public Timestamp getPostDate()
	{
		return postDate;
	}

	public void setPostDate(Timestamp postDate)
	{
		this.postDate = postDate;
	}

	public int getPostingId()
	{
		return postingId;
	}

	public void setPostingId(int postingId)
	{
		this.postingId = postingId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getCommentNum()
	{
		return commentNum;
	}

	public void setCommentNum(int commentNum)
	{
		this.commentNum = commentNum;
	}

	public boolean isIsdelete()
	{
		return isdelete;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setIsdelete(boolean isdelete)
	{
		this.isdelete = isdelete;
	}

	
	
	public Timestamp getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate)
	{
		this.updateDate = updateDate;
	}

	public Posting()
	{
		
	}

	public Posting(int postingId, int userId, String title, String content, int commentNum, boolean isdelete,
			Timestamp postDate, Timestamp updateDate)
	{
		this.postingId = postingId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.commentNum = commentNum;
		this.isdelete = isdelete;
		this.postDate = postDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString()
	{
		return "Posting [postingId=" + postingId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", commentNum=" + commentNum + ", isdelete=" + isdelete + ", postDate=" + postDate + ", updateDate="
				+ updateDate + "]";
	}

	
}
