package com.lihui.share.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihui.share.base.BaseController;
import com.lihui.share.service.IAdminService;
import com.lihui.share.util.ResultBean;


@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController
{
	@Autowired
	private IAdminService adminService;
	
	/**
	 验证管理员登录
	 */
	@ResponseBody
	@RequestMapping(value="/login.do")
	public ResultBean validAdminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String adName = request.getParameter("adName");
		String pwd = request.getParameter("password");
		ResultBean rb = ResultBean.getInstance();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean isPassed = adminService.queryAdminByAdNameAndPwd(adName, pwd);
//		if(isPassed)
//		{
//			request.getSession().setAttribute("admin", "admin");
//			return "redirect:/lihui/jsp/adminhomepage.jsp";
//		}
//		return "forward:adminlogin";
		if(isPassed)
		{
//			把登录名放入Session中
			request.getSession().setAttribute("admin", "admin");
//			response.sendRedirect(request.getContextPath() + "/lihui/jsp/userhomepage.jsp");
		}
		rb.setSuccess(isPassed);
		resultMap.put("success", isPassed);
		rb.setData(resultMap);
		return rb;
	}
}
