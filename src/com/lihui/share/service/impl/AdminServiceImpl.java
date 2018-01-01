package com.lihui.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihui.share.base.Base;
import com.lihui.share.dao.IAdminDao;
import com.lihui.share.entity.Admin;
import com.lihui.share.service.IAdminService;
import com.lihui.share.util.MyMD5Util;

@Service
public class AdminServiceImpl extends Base implements IAdminService
{
	@Autowired
	private IAdminDao adminDao;
	
	@Override
	public boolean queryAdminByAdNameAndPwd(String adName, String pwd)
	{
		boolean found = false;
		Admin admin = null;
		//md5加密
		String md5Pwd = MyMD5Util.getMD5(pwd);
		admin = adminDao.queryAdminByNameAndPwd(adName, md5Pwd);
		if(null != admin)
		{
			found = true;
		}
		return found;
	}

}
