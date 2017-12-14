package com.lihui.share.entity;

import java.sql.Timestamp;

public class Announcement
{
	private int anonounceId;
	
	private String title;
	
	private String content;
	
	private Timestamp publishTime;
	
	private Timestamp updateTime;
	
	private boolean isDelete;
	
	public Announcement()
	{
	}

	public Announcement(int anonounceID, String title, String content, Timestamp publishTime, Timestamp updateTime, boolean isDelete)
	{
		this.anonounceId = anonounceID;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}

	public int getAnonounceId()
	{
		return anonounceId;
	}

	public void setAnonounceId(int anonounceId)
	{
		this.anonounceId = anonounceId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Timestamp getPublishTime()
	{
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime)
	{
		this.publishTime = publishTime;
	}

	public Timestamp getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime)
	{
		this.updateTime = updateTime;
	}

	public boolean isDelete()
	{
		return isDelete;
	}

	public void setDelete(boolean isDelete)
	{
		this.isDelete = isDelete;
	}

	@Override
	public String toString()
	{
		return "Announcement [anonounceId=" + anonounceId + ", title=" + title + ", content=" + content
				+ ", publishTime=" + publishTime + ", updateTime=" + updateTime + ", isDelete=" + isDelete + "]";
	}
	
}
