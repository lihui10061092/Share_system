<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<%String name = (String)session.getAttribute("username");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Announces</title>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/jquery.easyui.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/userlogin.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/announcement.js"></script>


<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/metroblue/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/color.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/homepage.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/share.css"/>
<script type="text/javascript" language="javascript">
$(function(){  
	getAnnounces();
	});
</script>

</head>
<body class="">
<div id="a_detail">
 <table>
        <thead>
            <tr>
                <th>标题</th>
                <th>内容</th>
                <th>备注</th>
            </tr>
        </thead>
        <tbody id="tb1">
        </tbody>
    </table>

</div>

</body>
</html>