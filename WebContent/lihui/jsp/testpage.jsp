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


<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/color.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/homepage.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/demo/demo.css" />

<div>
<input class="easyui-filebox" style="width:300px">
</div>
</body>
</html>