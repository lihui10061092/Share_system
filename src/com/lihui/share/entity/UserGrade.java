package com.lihui.share.entity;
//用户得分
public class UserGrade
{
	//用户id
	private int userId;
	//所得分数，该用户所有分享平均分的总和
	private double grade;

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public double getGrade()
	{
		return grade;
	}

	public void setGrade(double grade)
	{
		this.grade = grade;
	}

	public UserGrade()
	{
		
	}
	
	public UserGrade(int userId, double grade)
	{
		this.userId = userId;
		this.grade = grade;
	}

	@Override
	public String toString()
	{
		return "UserGrade [userId=" + userId + ", grade=" + grade + "]";
	}
	
	
}
