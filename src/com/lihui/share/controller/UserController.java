package com.lihui.share.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lihui.share.base.BaseController;
import com.lihui.share.entity.User;
import com.lihui.share.service.IUserService;
import com.lihui.share.util.DateUtil;
import com.lihui.share.util.ResultBean;

/**
 * 
 * @author lihui
 * @Description 用户Controller层，与前台交互
 * @date 2017年3月22日
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/userlogin.do")
	@ResponseBody
	public ResultBean validUserlogin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String loginName = request.getParameter("loginName");
		String pwd = request.getParameter("password");
//		Map<String, String> paramMap = this.getAllParamsStringMap(request);
//		String loginName = paramMap.get("loginName");
//		String pwd = paramMap.get("password");
		User user = null;
		ResultBean rb = ResultBean.getInstance();
		Map<String, Object> data = new HashMap<String, Object>();
		boolean isValided = false;
		user = userService.findUserByLoginNameAndPwd(loginName, pwd);
		if(null != user)
		{
			isValided = true;
			//把登录名放入Session中
			request.getSession().setAttribute("username", user.getLoginame());
//			response.sendRedirect(request.getContextPath() + "/lihui/jsp/userhomepage.jsp");
		}
		rb.setSuccess(isValided);
		data.put("isValided", isValided);
		rb.setData(data);
		return rb;
	}
	
	@RequestMapping(value="/delete.do")
	@ResponseBody
	public ResultBean deleteUser(HttpServletRequest request, HttpServletResponse response)
	{
		ResultBean rb = ResultBean.getInstance();
		String user_id = request.getParameter("user_id");
		boolean isDeleted = userService.deleteUserById(Integer.parseInt(user_id));
		rb.setSuccess(isDeleted);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("isDelete", isDeleted);
		rb.setData(dataMap);
		return rb;
	}
	
	@RequestMapping(value="/allUser.do")
	@ResponseBody
	public ResultBean queryAllUser(HttpServletRequest request, HttpServletResponse response)
	{
		boolean success = false;
		ResultBean rb = ResultBean.getInstance();
		Map<String, Object> resultData = new HashMap<String, Object>();
		List<User> allUser = new ArrayList<User>();
		allUser = userService.findAll();
		if(allUser.size() > 0)
		{
			success = true;
		}
		resultData.put("data", allUser);
		rb.setSuccess(success);
		rb.setData(resultData);
		return rb;
	}
	
	@RequestMapping(value="/addUser.do")
	@ResponseBody
	public ResultBean addUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		ResultBean rb = ResultBean.getInstance();
		boolean isSuccess = true;
		request.setCharacterEncoding("utf-8");
//		Map<String, String> allParams = this.getAllParamsStringMap(request);
		Map<String, Object> allObjParams = this.getAllParamsMap(request);
		allObjParams.remove("password1");
		String hireDateStr = (String) allObjParams.get("hiredate");
		allObjParams.remove("hiredate");
		Date hireDate = DateUtil.strToDate(hireDateStr);
		allObjParams.put("hiredate", hireDate);
		//查询登录名是否已经注册
		//Map中的Key是前端input 的name属性
		String loginame = (String) allObjParams.get("loginame");
//		String pwd = (String) allObjParams.get("pwd");
		User user = userService.findUserByLoginName(loginame);
		Map<String, Object> data = new HashMap<String, Object>();
		//已经注册，返回前台提示用户已经存在
		if(null != user)
		{
			isSuccess = false;
		}
		else
		{//未注册，进行注册
//			Map<String, String> allParams = new HashMap<String, String>();
			userService.insertUser(allObjParams);
		}

		data.put("success", isSuccess);
		rb.setSuccess(isSuccess);
		rb.setData(data);
//		
		return rb;
	}
	
	@RequestMapping(value="/updateUser.do")
	@ResponseBody
	public ResultBean updateUser(HttpServletRequest request, HttpServletResponse response)
	{
		ResultBean rb = ResultBean.getInstance();
		Map<String, Object> updateParams = this.getAllParamsMap(request);
		userService.updateUser(updateParams);
		rb.setSuccess(true);
		List<User> allUsers = userService.findAll();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", allUsers);
		rb.setData(data);
		return rb;
	}
}
