package com.lihui.share.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lihui.share.base.Base;
import com.lihui.share.entity.Share;
import com.lihui.share.entity.User;
import com.lihui.share.service.IShareService;
import com.lihui.share.service.IUserService;
import com.lihui.share.util.DateUtil;
import com.lihui.share.util.ResultBean;

@Controller
@RequestMapping("/share")
public class ShareController extends Base
{
	@Autowired
	private IShareService shareService;

//	@Autowired
//	private FileUploadService fileUploadService;

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/addshare.do")
	@ResponseBody
	public ResultBean addShare(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResultBean rb = ResultBean.getInstance();
		String type = request.getParameter("type");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
//		String fileNames = request.getParameter("sourceFile");//取不到。在后面的Multipart处理中获取文件名，同时重命名上传的文件
		String shareDateStr = request.getParameter("sharedate");
		Date shareDate = DateUtil.strToDate(shareDateStr);
		String uploadFileNames = "";
		StringBuilder fileNamesSb = new StringBuilder();
		
		String curUserLoginName = (String) request.getSession().getAttribute("username");
		User curUser = userService.findUserByLoginName(curUserLoginName);
		int userId = curUser.getUser_id();
		
		Map<String, Object> addParamMap = new HashMap<String, Object>();
		addParamMap.put("type", type);
		addParamMap.put("subject", subject);
		addParamMap.put("content", content);
		addParamMap.put("u_id", Integer.valueOf(userId));
		addParamMap.put("s_time", shareDate);
//		addParamMap.put("attachments", "Spring核心及其应用示例.pptx,Spring Boot入门");
		//新建时默认听课人数，评分等为0
		addParamMap.put("grade", Double.valueOf(0));
		addParamMap.put("stu_num", Integer.valueOf(0));
		addParamMap.put("grade_num", Integer.valueOf(0));
		addParamMap.put("ad_grade", Integer.valueOf(0));
		// 创建一个通用的Multipart解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即Multipart请求
		if (multipartResolver.isMultipart(request))
		{
			// 转换成Multipart request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的数据
			Iterator<String> iter = multiRequest.getFileNames();
//			File uploadFile = null;
			String filePath = "D:/workspace/Share_system/uploadFiles/";
			while (iter.hasNext())
			{
				String curFileName = iter.next();
				// 取得上传文件(多个)
				List<MultipartFile> files = multiRequest.getFiles(curFileName);
//				fileNamesSb.append(curFileName).append(",");
				for(MultipartFile file : files)
				{
					if (file != null)
					{
						// 取得当前上传文件的文件名称
						String priNames = file.getOriginalFilename();
						logger.info("============priNames: " + priNames);
						fileNamesSb.append(priNames).append(",");
//						String priName = priNames.substring(0, priNames.indexOf("."));
//						InputStream stream = file.getInputStream();
						if (!"".equals(priNames))
						{ // 可以重命名上传后的文件名

//							uploadFile = new File(filePath + "" + priNames);
//							docType = priNames.substring((priNames.lastIndexOf(".")));
//							fileUploadService.saveFile(priName, filePath, docType);
//							fileService.SaveFileFromInputStream(stream, filePath, priNames);
							file.transferTo(new File(filePath+ "" + priNames));
						}
					}
				}
				
			}
		}
		//上传文件完成后，增加分享
		uploadFileNames = fileNamesSb.toString();
		//去掉最后一个逗号
		uploadFileNames = uploadFileNames.substring(0,uploadFileNames.length()-1);
		addParamMap.put("attachments", uploadFileNames);
		shareService.addShare(addParamMap);
		rb.setSuccess(true);
		return rb;
	}

	@RequestMapping(value = "/deleteshare.do")
	@ResponseBody
	public ResultBean deleteShare(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResultBean rb = ResultBean.getInstance();
		return rb;
	}

	@RequestMapping(value = "/updateshare.do")
	@ResponseBody
	public ResultBean updateShare(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResultBean rb = ResultBean.getInstance();
		return rb;
	}

	@RequestMapping(value = "/queryShareById.do")
	@ResponseBody
	public ResultBean queryShareById(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResultBean rb = ResultBean.getInstance();
		return rb;
	}

	// 用户首页分页查询
	@RequestMapping(value = "/queryMyShareByPage.do")
	@ResponseBody
	public JSONObject queryMyShareByPage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// 使用JSONObject返回数据，而不是ResultBean
		JSONObject jo = new JSONObject();
		// 当前页数
		int pageIndex = Integer.valueOf(request.getParameter("page"));
		// 每页显示几条数据
		int row = Integer.valueOf(request.getParameter("rows"));
		String curUserLoginName = (String) request.getSession().getAttribute("username");
		User curUser = userService.findUserByLoginName(curUserLoginName);
		int userId = curUser.getUser_id();
		List<Share> myShareList = shareService.findMyShareByPage(pageIndex, row, userId);
//		List<Share> myShareList = shareService.filterMyShare(shares, userId);
		// JSONArray ja = new JSONArray(shares);
		// 将List<?>转换成JSONArray对象
		int shareCounts = shareService.getMyShareCounts(userId);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(myShareList));
		// jo.put("total", shares.size());
		//前端需要总条数，以及数据，来计算分页显示
		jo.put("total", shareCounts);
		jo.put("rows", ja);
		return jo;
	}

	//首页查询分享，不查询自己创建的
	@RequestMapping(value = "/queryOthersShareByPage.do")
	@ResponseBody
	public JSONObject queryOthersShareByPage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// 使用JSONObject返回数据，而不是ResultBean
		JSONObject jo = new JSONObject();
		//当前用户登录名
		String curUserLoginName = (String) request.getSession().getAttribute("username");
		User curUser = userService.findUserByLoginName(curUserLoginName);
		int userId = curUser.getUser_id();
		// 当前页数
		int pageIndex = Integer.valueOf(request.getParameter("page"));
		// 每页显示几条数据
		int row = Integer.valueOf(request.getParameter("rows"));
		List<Share> allOtherShares = shareService.findOthersShareByPage(pageIndex, row, userId);
		//filter位置有问题
//		List<Share> shares = shareService.filterOthersShare(allShares, userId);
		// JSONArray ja = new JSONArray(shares);
		// 将List<?>转换成JSONArray对象
//		int allShareCounts = shareService.getAllShareCounts();
//		int myShareCounts = shareService.getMyShareCounts(userId);
		int othersShareCounts = shareService.getOthersShareCounts(userId);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(allOtherShares));
		// jo.put("total", shares.size());
		//前端需要总条数，以及数据，来计算分页显示
		jo.put("total", othersShareCounts);
		jo.put("rows", ja);
		return jo;
	}
	
	// @RequestMapping(value="/getPageCount.do")
	// @ResponseBody
	// public ResultBean calculatePageCounts(HttpServletRequest request,
	// HttpServletResponse response) throws IOException
	// {
	// ResultBean rb = ResultBean.getInstance();
	// return rb;
	// }
}
