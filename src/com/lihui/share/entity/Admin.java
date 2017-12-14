package com.lihui.share.entity;

public class Admin
{
	private String adName;
	
	private String pwd;

	public String getAdName()
	{
		return adName;
	}

	public void setAdName(String adName)
	{
		this.adName = adName;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	public Admin()
	{
		
	}
	
	public Admin(String name, String password)
	{
		this.adName = name;
		this.pwd = password;
	}

	@Override
	public String toString()
	{
		return "Admin [adName=" + adName + ", pwd=" + pwd + "]";
	}
	
	
}
