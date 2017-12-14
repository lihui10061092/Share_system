<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<%String name = (String)session.getAttribute("username");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userhomepage</title>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/mypage.js"></script>


<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/color.css" />
 <link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/homepage.css" />
 <!-- 

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/jpage.css" />
-->
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/demo/demo.css" />
	
</head>
<body>
	<div data-options="region:'north',split:true" style="height: 100px;">
		<ul id="nav">
			<li><a
				href="http://localhost:8080/Share_system/lihui/jsp/homepage.jsp?curUser=<%=name%> target='_Blan'">首页</a></li>
			<li><a href="">在线聊</a></li>
			<li><a href="">话题圈</a></li>
			<li><a href="">我的帖子</a></li>
			<li><a href="">我的评分</a></li>
			<li><a href="">技术支持</a></li>
			<li><a href="">下拉退出</a></li>
		</ul>
	</div>
	
	
	<div style="margin:20px 0;"></div>
	<div >
			<br />
			<table id="mytable" style="width:100%;height:550px"
			data-options="rownumbers:true,title:'我的分享',singleSelect:true,pagination:true,
			url:'/Share_system/share/queryMyShareByPage.do',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'type',width:100">类型</th>
				<th data-options="field:'subject',width:100">主题</th>
				<th data-options="field:'content',width:260">内容</th>
				<th data-options="field:'attachements',width:600,align:'left'">附件</th>
				<th data-options="field:'studentNum',width:150,align:'right'">听课人数</th>
			</tr>
		</thead>
	</table>
			</div>
	
	
	
	<div id="sharedialog" style="display:none; padding:5px; width:1081px; height:540px;">
		<form id="addShareForm" name="addShareForm" enctype="multipart/form-data" method="post" style="width:1080px; height:540px;">
			<table border="0" cellpadding="0" cellspacing="0" style="width:400px">
				<tr>
					<td nowrap align="left" style="height: 35px">分享类型：</td>
					<td nowrap align="left"><input id="type" name="type" class="easyui-combobox" style="width:66%" 
					data-options="
						valueField: 'label',
						textField: 'value',
						data: [{
							label: 'Java',
							value: 'Java技术'
						},{
							label: 'JavaScript',
							value: '前端技术'
						},{
							label: 'db',
							value: '数据库'
						},{
							label: 'softpkg',
							value: '软件包'
						},{
							label: 'hr',
							value: '人事培训'
						}
						]" />
					</td>
				</tr>
				<tr>
					<td nowrap align="left" style="height: 35px">分享主题：</td>
					<td style="height: 70px" align="left">
					<input id="subject" name="subject" type="text"class="easyui-textbox" data-options="multiline:true" style="width:100%;height:60px"/>
						</td>
				</tr>
				<tr>
					<td nowrap align="left" style="height: 35px">分享内容：</td>
					<td style="height: 70px" align="left">
					<input id="content" name="content" type="text"class="easyui-textbox" data-options="multiline:true" style="width:100%;height:80px"/>
						</td>
				</tr>
				<tr>
					<td nowrap align="left" style="height: 35px">分享材料：</td>
					<td><input id="uploadfiles" class="easyui-filebox"  name="sourceFile"
                    data-options="buttonAlign:'right',buttonText:'请选择文件..',multiple:true,separator:';'"
					style="width:100%"
					></td>
				</tr>
				<!--  
				<tr>
				<td align="right" style="height: 35px">
				<a class="easyui-linkbutton" iconCls="icon-save" onclick="uploadFiles()">Upload</a>
				
				</td>
				</tr>
				-->
				<tr>
				<td nowrap align="left" style="height: 35px">分享日期：</td>
					<td align="left" ><input  id="sharedate"  name="sharedate" type= "text" class= "easyui-datebox" style="width:50%;"> 
					</input> </td>
				</tr>
			</table>
		</form>
		<div border="false">
                <a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveShare()">确定</a>
                <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeDialog()">关闭</a>
        </div>
	</div>
</body>
</html>