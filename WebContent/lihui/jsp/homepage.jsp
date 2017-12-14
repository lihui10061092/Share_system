<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<%String name = (String)session.getAttribute("username");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>homepage</title>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/jQuery/jquery-2.2.3.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/jquery.easyui.min.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/easyUI/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/userlogin.js"></script>
<script type="text/javascript" language="javascript" src="<%=contextPath%>/lihui/js/announcement.js"></script>


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
	getAnnounceTitles();
	});
function deal_auther(value,row,rowIndex) {
    if(row.auther!=undefined){
        return row.auther.emp_id;
    }
}
</script>
</head>
<body class="easyui-layout">
<!--
<div>
<h3>当前登录用户：<%=name%>
</h1> 
</div>
-->

<div data-options="region:'north',split:true" style="height:100px;">
<ul id="nav"> 
<li><a href=http://localhost:8080/Share_system/lihui/jsp/userhomepage.jsp?curUser=<%=name%> target="_Blan">我的首页</a></li> 
<li><a href="">所有分享</a></li> 
<li><a href="">在线聊</a></li> 
<li><a href="">话题圈</a></li> 
<li><a href="">技术支持</a></li> 
<li><a href="">我的课程</a></li> 
<li><a href="">下拉退出</a></li> 
</ul> 
<div>当前用户：<%=name%></div>
 </div>   
    <div data-options="region:'south',title:'版权信息',split:true" style="height:100px;">
    <div>CopyRight Elead2017</div>
    </div>   
    <div data-options="region:'east',title:'日历',split:true" style="width:210px">
    <div id="calendar" class="easyui-calendar" style="width:180px;height:200px;"></div>  
    </div>   
    <div id="announces" data-options="region:'west',title:'公告',split:true" style="width:250px;">
    </div>   
    <div data-options="region:'center',title:'最近分享'" style="padding:5px;background:#eee;">
    <div >
    <table id="homepagemytable" class="easyui-datagrid" style="width:100%;height:550px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,
			url:'/Share_system/share/queryOthersShareByPage.do',method:'get'">
		<thead>
			<tr>
			<!--  
				<th data-options="field:'type',width:100">类型</th>
				<th data-options="field:'subject',width:100">主题</th>
				<th data-options="field:'content',width:260">内容</th>
				<th data-options="field:'attachements',width:600,align:'left'">附件</th>
				<th data-options="field:'auther',width:200,align:'left'">讲师</th>
				<th data-options="field:'studentNum',width:100,align:'left'">听课人数</th>
				<th data-options="field:'myScore',width:100">我的评分</th>
				-->
				<th field='type' width='100'>类型</th>
				<th field='subject' width='100'>主题</th>
				<th field='content' width='260'>内容</th>
				<th field='attachements' width='600' align='left'>附件</th>
				<th field='auther' width='200' formatter='deal_auther' align='left'>讲师</th>
				<th field='studentNum' width='100' align='left'>听课人数</th>
				<th field='myScore' width='100'>我的评分</th>
			</tr>
		</thead>
	</table>
    </div>
    </div>   
</body>
</html>