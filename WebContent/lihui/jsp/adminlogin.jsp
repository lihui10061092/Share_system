<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>企业信息管理系统-登录</title>
	<link href="<%=contextPath%>/lihui/css/adminlogin.css" rel="stylesheet" type="text/css" />
 </head>
 
 <body>
 	<div class="second_body">
    	<form id="adminLoginForm" method="post">
        	<div class="logo"></div>
            <div class="title-zh">企业分享管理系统</div>
            <div class="title-en" style="">Enterprise Share Manage System</div>
            <div class="message" data-bind="html:message"></div>
            <table border="0" style="width:300px;">
            	<tr>
                	<td style="white-space:nowrap; padding-bottom: 5px;width:55px;">用户名：</td>
                    <td colspan="2"><input type="text" name="adName" id="adName" class="login" /></td>
                </tr>
                <tr>
                    <td class="lable" style="white-space:nowrap; letter-spacing: 0.5em; vertical-align: middle">密码：</td>
                    <td colspan="2"><input type="password" name="password" id="password" class="login"  /></td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"><input type="checkbox" /><span>系统记住我</span></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align:center">
                        <input type="button" value="登录" class="login_button" onclick="adminLogin()"/>
                        <input type="button" value="重置" class="reset_botton" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
        
 	<script type="text/javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/lihui/js/jquery.cookie.js"></script>
    <!-- 
    <script type="text/javascript" src="<%=contextPath%>/lihui/js/utils.js"></script>
     -->
	<script type="text/javascript" src="<%=contextPath%>/lihui/js/common.js"></script> 
    <script type="text/javascript" src="<%=contextPath%>/lihui/js/knockout-3.4.1.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/lihui/js/adminlogin.js"></script>
 	<!--  
 	<script type="text/javascript">
 		$(function () {
 			ko.applyBindings(new viewModel());
 		});
 		
 	</script>
 	-->
 </body>
</html>       