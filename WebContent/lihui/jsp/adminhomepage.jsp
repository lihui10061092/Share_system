<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<%String admin = (String)session.getAttribute("admin");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin homepage</title>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/jquery.easyui.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/mytree.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/usermanagement.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/jquery.cookie.js"></script>

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/metroblue/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/easyUI/themes/color.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/homepage.css"/>
<!--
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/share.css"/>
<script type="text/javascript" language="javascript">
//自动执行的函数
$(function(){  
	$('#dd').datebox({    
	    required:true   	
	});
	});
	<div>
<input  id="dd"  type= "text" class= "easyui-datebox" required ="required"> </input> 
</div>
</script>
-->
<script type="text/javascript" language="javascript">
$(function(){
	clickTreeNode();
	});
</script>
</head>
<body class="easyui-layout">
<!--
<div>
<h3>当前登录用户：<%=admin%>
</h1> 
</div>
-->

<div data-options="region:'north',split:true" style="height:100px;">
<ul id="nav"> 
<li><a href="">所有分享</a></li> 
<li><a href="">在线聊</a></li> 
<li><a href="">话题圈</a></li> 
<li><a href="">退出登录</a></li> 
</ul> 
<div>欢迎您，<%=admin%></div>
 </div>   
    <div data-options="region:'south',title:'版权信息',split:true" style="height:100px;">
    <div>CopyRight Lihui@2017</div>
    </div>   
      
    <div id="management" data-options="region:'west',title:'管理',split:true" style="width:250px;">
    <ul id="mytree" class="easyui-tree" 
    >   
    <li>   
        <span>平台管理</span>   
        <ul>   
            <li>   
                <span>用户管理</span>   
            </li>   
            <li>   
                <span>分享管理 </span>   
            </li> 
             <li>   
                <span>公告管理 </span>   
            </li>
             <li>   
                <span>论坛管理 </span>   
            </li>  
        </ul>   
    </li>   
    
    </ul>  
    
 </div> 
 <div data-options="region:'center'" style="padding:0px;background:#eee;">
 <div id="mytab1" class="easyui-tabs" style="width:95%;height:80%;"> 
 <!-- 
    <div title="Tab1" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
        tab1    
    </div>   
    -->  
 </div>
 </div>  
   
</body>
</html>