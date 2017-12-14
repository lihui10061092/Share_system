package com.lihui.share.entity;

import java.util.Date;
import java.util.Map;

import com.lihui.share.util.DateUtil;

public class Share
{
	//分享ID
	private int shareId;
	//类型（技术、营销等）
	private String type;
	//主题
	private String subject;
	//内容
	private String content;
	//分享人ID
//	private int userId;
	private User auther;
	
//	private String autherId;
	//日期	
	private Date shareDate;
	//附件名称
	private String attachements;
	//评分（平均分）
	private double grade;
	//听课人数
	private int studentNum;
	//评分人数，不包含管理员
	private int grade_num;
	//管理员评分
	private int adGrade;
	
	public int getShareId()
	{
		return shareId;
	}
	public void setShareId(int shareId)
	{
		this.shareId = shareId;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
//	public int getUserId()
//	{
//		return userId;
//	}
//	public void setUserId(int userId)
//	{
//		this.userId = userId;
//	}
	public Date getShareDate()
	{
		return shareDate;
	}
	public void setShareDate(Date shareDate)
	{
		this.shareDate = shareDate;
	}
	public String getAttachements()
	{
		return attachements;
	}
	public void setAttachements(String attachements)
	{
		this.attachements = attachements;
	}
	public double getGrade()
	{
		return grade;
	}
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	public int getStudentNum()
	{
		return studentNum;
	}
	public void setStudentNum(int studentNum)
	{
		this.studentNum = studentNum;
	}
	public int getGrade_num()
	{
		return grade_num;
	}
	public void setGrade_num(int grade_num)
	{
		this.grade_num = grade_num;
	}
	public int getAdGrade()
	{
		return adGrade;
	}
	public void setAdGrade(int adGrade)
	{
		this.adGrade = adGrade;
	}
	public User getAuther()
	{
		return auther;
	}
	public void setAuther(User auther)
	{
		this.auther = auther;
	}
	
//	public String getAutherId()
//	{
//		return autherId;
//	}
//	public void setAutherId(User auther)
//	{
//		this.autherId = auther.getEmp_id();
//	}
	public Share()
	{
		
	}
	
	public Share(int shareId, String type, String subject, String content,  int userId, Date shareDate,
			String attachements, double grade, int studentNum, int grade_num, int adGrade, User user)
	{
		this.shareId = shareId;
		this.type = type;
		this.subject = subject;
		this.content = content;
//		this.userId = userId;
		this.shareDate = shareDate;
		this.attachements = attachements;
		this.grade = grade;
		this.studentNum = studentNum;
		this.grade_num = grade_num;
		this.adGrade = adGrade;
		this.auther = user;
//		this.autherId = user.getEmp_id();
	}
	
	public Share(Map<String, String> shareMap)
	{
		this.shareId = Integer.parseInt(shareMap.get("shareId"));
		this.type = shareMap.get("type");
		this.subject = shareMap.get("subject");
		this.content = shareMap.get("content");
//		this.userId = Integer.parseInt(shareMap.get("userId"));
		this.shareDate = DateUtil.strToDate(shareMap.get("shareDate"));
		this.attachements = shareMap.get("attachements");
		this.grade = Double.parseDouble(shareMap.get("grade"));
		this.studentNum = Integer.parseInt(shareMap.get("studentNum"));
		this.grade_num = Integer.parseInt(shareMap.get("grade_num"));
		this.adGrade = Integer.parseInt(shareMap.get("adGrade"));
	}
	
	@Override
	public String toString()
	{
		return "Share [shareId=" + shareId + ", type=" + type + ", subject=" + subject + ", content=" + content
				+ ", auther=" + auther + ", shareDate=" + shareDate + ", attachements=" + attachements + ", grade="
				+ grade + ", studentNum=" + studentNum + ", grade_num=" + grade_num + ", adGrade=" + adGrade + "]";
	}
	
}
