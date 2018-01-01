<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/jquery.easyui.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/userlogin.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/userregister.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/validate.js"></script>


<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/metroblue/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/color.css"/>

<!-- insdep_theme_default.css
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/share.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/insdep/insdep_theme_default.css"/>
<link href="https://cdn.insdep.com/themes/1.0.0/easyui.css" rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/icon.css" rel="stylesheet" type="text/css">

</head>
<!-- <body style="background: url(../images/loginbg.jpg)"> -->
<body>
<!-- class="easyui-window" background:url(../images/loginbg.jpg); -->

<div id="loginWin" class="easyui-window" title="用户登录" style="width:450px;height:250px;padding:5px;"
   minimizable="false" maximizable="false" resizable="true" collapsible="false">
    <div class="easyui-layout" fit="true">
       <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
        <form id="loginForm" method="post">
            <div style="padding:5px 0;">
                <label for="login" style="display:inline-block;width:40px;">登录名:</label>
                <input class="easyui-validatebox" type="text" name="login" style="width:260px;" data-options="required:true"></input>
            </div>
            <div style="padding:5px 0;">
                <label for="password" style="display:inline-block;width:40px;"> 密 码:</label>
                <input class="easyui-validatebox" type="password" name="password" style="width:260px;" data-options="required:true"></input>
            </div>
             <div  id="showMsg" style="padding:5px 0; text-align:center; color:red;"></div>
              <div region="south" border="false" style="text-align:left;padding:5px 0;">
            </div>
            
        </form>
            </div>
            <!-- icon-cancel icon-mini-refresh onclick="userLogin() -->
            <div region="south" border="false" style="text-align:left;padding:5px 0;">
                <a class="easyui-linkbutton" iconCls="icon-ok" onclick="userLogin()">登录</a>
                <a class="easyui-linkbutton" iconCls="icon-mini-refresh" href="javascript:void(0)" onclick="cleardata()">重置</a>
                <a class="easyui-linkbutton" iconCls="icon-add" href="javascript:void(0)" onclick="userRegister()">注册</a>
            </div>
            
    </div>
</div>
<div id="mydialog" style="display:none; padding:5px; width:1081px; height:900px;">
		<form id="addUserForm" name="addUserForm"  method="post" style="width:900px; height:540px;">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td nowrap align="right" style="height: 35px">登录名：</td>
					<td><input type="text" id="loginame" name="loginame"
						class="easyui-validatebox" data-options="required:true"></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">姓名：</td>
					<td><input id="name" name="name" type="text"
						class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">性别：</td>
					<td><input id="Man" name="sex" type="radio" value="M"
						checked="checked">M<input id="Women" name="sex"
						type="radio" value="F">F</td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">工号：</td>
					<td><input id="emp_id" name="emp_id" type="text"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">密码：</td>
					<td><input id="password" name="pwd" type="password"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">确认密码：</td>
					<td><input id="password1" name="pawword1" type="password"
						class="easyui-validatebox" data-options="required:true" validType="equalTo['#password']" invalidMessage="两次输入密码不匹配"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">邮箱：</td>
					<td><input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" /></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">手机号：</td>
					<td><input class="easyui-validatebox" type="text" name="tel" validtype="mobile" /></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">住址：</td>
					<td><input class="easyui-validatebox" type="text" name="addr"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">公司：</td>
					<td><input class="easyui-validatebox" type="text" name="company"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">部门：</td>
					<td><input class="easyui-validatebox" type="text" name="dept"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">项目组：</td>
					<td><input class="easyui-validatebox" type="text" name="project"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height: 35px">职位：</td>
					<td><input class="easyui-validatebox" type="text" name="position"/></td>
				</tr>
				<tr>
					<td nowrap align="right" style="height:35px">级别：</td>
					<td><input class="easyui-validatebox" type="text" name="level"/></td>
				</tr>
				<tr>
				<td nowrap align="right" style="height: 35px">入职日期：</td>
					<td><input  id="hiredate"  name="hiredate" type= "text" class= "easyui-datebox" style="width:100%;"> </input> </td>
				</tr>
			</table>
		</form>
		<div border="false">
                <a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">注册</a>
                <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeDialog()">关闭</a>
        </div>
	</div>
	
</body>
</html>