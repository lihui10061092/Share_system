package com.lihui.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	/**
	 验证管理员登录
	 */
	@ResponseBody
	@RequestMapping(value="/validLogin.do")
	public boolean validAdminLogin()
	{
		boolean isPassed = false;
		//TODO
		return isPassed;
	}
}
