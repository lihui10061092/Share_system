package com.lihui.share.entity;
//记录每个用户对分享的评分
public class ShareGrade
{
	//分享id
	private int shareId;
	//评分人id
	private int userId;
	//所评分数
	private int grade;
	
	public int getShareId()
	{
		return shareId;
	}
	public void setShareId(int shareId)
	{
		this.shareId = shareId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getGrade()
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	
	public ShareGrade()
	{
		
	}
	
	public ShareGrade(int shareId, int userId, int grade)
	{
		this.shareId = shareId;
		this.userId = userId;
		this.grade = grade;
	}
	
	@Override
	public String toString()
	{
		return "ShareGrade [shareId=" + shareId + ", userId=" + userId + ", grade=" + grade + "]";
	}
	
}
