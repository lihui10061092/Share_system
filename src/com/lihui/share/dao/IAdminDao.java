package com.lihui.share.dao;

import org.apache.ibatis.annotations.Param;

import com.lihui.share.annotation.LHAnnotation;
import com.lihui.share.entity.Admin;
@LHAnnotation("iAdminDao")
public interface IAdminDao
{
	//使用注解传递参数
	public Admin queryAdminByNameAndPwd(@Param("ad_name")String adminName, @Param("pwd")String pwd);
}
