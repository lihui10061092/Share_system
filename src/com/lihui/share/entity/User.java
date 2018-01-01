package com.lihui.share.entity;


public class User
{
	//用户id
	private int user_id;
	//登录名
	private String loginame;
	//名字
	private String name;
	
	//性别
	private String sex;
	
	//工号
	private String emp_id;
	//密码
	private String pwd;
	//邮箱
	private String email;
	//手机号
	private String tel;
	//住址
	private String addr;
	//公司
	private String company;
	//部门
	private String dept;
	//项目组
	private String project;
	//职位ְ
	private String position;
	//级别
	private String level;
	
	//入职日期
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private String hiredate;

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getHiredate()
	{
		return hiredate;
	}

	public void setHiredate(String hiredate)
	{
		this.hiredate = hiredate;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getLoginame()
	{
		return loginame;
	}

	public void setLoginame(String loginame)
	{
		this.loginame = loginame;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmp_id()
	{
		return emp_id;
	}

	public void setEmp_id(String emp_id)
	{
		this.emp_id = emp_id;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getAddr()
	{
		return addr;
	}

	public void setAddr(String addr)
	{
		this.addr = addr;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getDept()
	{
		return dept;
	}

	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public User()
	{
		
	}
	
	public User(int userId, String empId)
	{
		this.user_id = userId;
		this.emp_id = empId;
	}
	
	public User(int userId, String loginName, String name, String empId, String password, String email, String telNum,
			String addr, String company, String dept, String project, String position, String level, String hireDate)
	{
		this.user_id = userId;
		this.loginame = loginName;
		this.name = name;
		this.emp_id = empId;
		this.pwd = password;
		this.email = email;
		this.tel = telNum;
		this.addr = addr;
		this.company = company;
		this.dept = dept;
		this.project = project;
		this.position = position;
		this.level = level;
		this.hiredate = hireDate;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + user_id + ", loginName=" + loginame + ", name=" + name + ", empId=" + emp_id
				+ ", password=" + pwd + ", email=" + email + ", telNum=" + tel + ", addr=" + addr + ", company="
				+ company + ", dept=" + dept + ", project=" + project + ", position=" + position + ", level=" + level
				+ "]";
	}
	
}
