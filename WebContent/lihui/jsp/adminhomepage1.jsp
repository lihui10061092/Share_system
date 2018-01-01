<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%String contextPath = request.getContextPath();%>
<%String name = (String)session.getAttribute("admin");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <!-- TopJUI框架样式 -->
    <link type="text/css" href="<%=contextPath%>/lihui/topjui/css/topjui.core.min.css" rel="stylesheet">
    <link type="text/css" href="<%=contextPath%>/lihui/topjui/themes/default/topjui.red.css" rel="stylesheet" id="dynamicTheme"/>
    <!-- FontAwesome字体图标 -->
    <link type="text/css" href="<%=contextPath%>/lihui/static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- layui框架样式 -->
    <link type="text/css" href="<%=contextPath%>/lihui/static/plugins/layui/css/layui.css" rel="stylesheet"/>
    
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/lihui/css/homepage.css"/>
    <!-- jQuery相关引用 -->
    <script type="text/javascript" src="<%=contextPath%>/lihui/static/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/lihui/static/plugins/jquery/jquery.cookie.js"></script>
    <!-- TopJUI框架配置 -->
    <script type="text/javascript" src="<%=contextPath%>/lihui/static/public/js/topjui.config.js"></script>
    <!-- TopJUI框架核心-->
    <script type="text/javascript" src="<%=contextPath%>/lihui/topjui/js/topjui.core.min.js"></script>
    <!-- TopJUI中文支持 -->
    <script type="text/javascript" src="<%=contextPath%>/lihui/topjui/js/locale/topjui.lang.zh_CN.js"></script>
    <!-- layui框架js -->
    <script src="<%=contextPath%>/lihui/static/plugins/layui/layui.js" charset="utf-8"></script>
</head>

<body>
<div data-toggle="topjui-layout" data-options="fit:true">
    
    <div data-options="region:'north',split:true" style="height:100px;">
		<ul id="nav"> 
		<li><a href="">所有分享</a></li> 
		<li><a href="">在线聊</a></li> 
		<li><a href="">话题圈</a></li> 
		<li><a href="">退出登录</a></li> 
		</ul> 
<div>欢迎您，<%=name%>！</div>
    </div>
    <div data-options="region:'west',title:'',split:true,border:false,width:'20%',iconCls:'fa fa-sitemap',headerCls:'border_right',bodyCls:'border_right'">
        <!-- treegrid表格 -->
        <table data-toggle="topjui-treegrid"
               data-options="id:'adminDatagrid',
			   idField:'id',
			   treeField:'text',
			   url:'<%=contextPath%>/lihui/json/menu_1.json',"
			   >
            <thead>
            <tr>
            <!-- 
                <th data-options="field:'uuid',title:'UUID',checkbox:false"></th>
                 -->
                <th data-options="field:'text',title:'Management',width:100"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'center',iconCls:'icon-reload',title:'',split:true,border:true,bodyCls:'border_top_none'">
        <div data-toggle="topjui-layout" data-options="fit:true">
            <div data-options="region:'center',title:'',fit:false,split:true,border:false,bodyCls:'border_bottom'"
                 style="height:60%">
                <!-- datagrid表格 -->
                <table data-toggle="topjui-datagrid"
                       data-options="id:'userDg',
                       idField:'uuid',
                       treeField:'taskType',
                       pagination:true,
                       striped:true,
                       fitColumns:true,
                       rownumbers: true,
                       type:'post',
                       url:'http://localhost:8080/Share_system/user/allUser.do',
                       parentGrid:{
                           type:'treegrid',
                           id:'codeItemDatagrid',
                           param:'unitId:id'
                       },
			           childTabs: [{id:'southTabs'}]">
                    <thead>
                    <tr>
                    <!-- -->
                        <th data-options="field:'uuid',title:'UUID',checkbox:true"></th>
                         
                        <th data-options="field:'emp_id',title:'工号',sortable:true"></th>
                        <th data-options="field:'name',title:'姓名',sortable:true"></th>
                        <th data-options="field:'sex',title:'性别',sortable:true,
                        formatter:function(value,row,index){
                            if (value == '1') {
                                return '男';
                            } else if (value == '2') {
                                return '女';
                            } else {
                                return '';
                            }
                        }"></th>
                        
                        <th data-options="field:'email',title:'电子邮箱',sortable:true"></th>
                        <th data-options="field:'tel',title:'手机号',sortable:true"></th>
                        <th data-options="field:'addr',title:'住址',sortable:true"></th>
                        <th data-options="field:'company',title:'公司',sortable:true"></th>
                        <th data-options="field:'dept',title:'所属部门',sortable:true"></th>
                        <th data-options="field:'project',title:'项目组',sortable:true"></th>
                        <th data-options="field:'position',title:'职位',sortable:true"></th>
                        <th data-options="field:'level',title:'级别',sortable:true"></th>
                        <th data-options="field:'hiredate',title:'入职日期',sortable:true"></th>
                        
                    </tr>
                    </thead>
                </table>
            </div>
            <div data-options="region:'south',fit:false,split:true,border:false"
                 style="height:40%">
                <div data-toggle="topjui-tabs"
                     data-options="id:'southTabs',
                     fit:true,
                     border:false,
                     parentGrid:{
                         type:'datagrid',
                         id:'userDg',
                         param:'puuid:uuid'
                     }">
                    <div title="Panel面板"
                         data-options="id:'tab8',
                         iconCls:'fa fa-th',
                         href:''"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 表格工具栏开始 -->
<div id="userDg-toolbar" class="topjui-toolbar"
     data-options="grid:{
           type:'datagrid',
           id:'userDg'
       }">
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'openDialog',
       extend: '#userDg-toolbar',
       iconCls: 'fa fa-plus',
       dialog:{
           id:'userAddDialog',
           href:_ctx + '/html/complex/dialog_add.html',
           buttonsGroup:[
               {text:'保存',url:_ctx + '/json/response/success.json',iconCls:'fa fa-plus',handler:'ajaxForm',btnCls:'topjui-btn-normal'}
           ]
       }">新增</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method: 'openDialog',
            extend: '#userDg-toolbar',
            iconCls: 'fa fa-pencil',
            btnCls: 'topjui-btn',
            grid: {
                type: 'datagrid',
                id: 'userDg'
            },
            dialog: {
                width: 950,
                height: 500,
                href: _ctx + '/html/complex/user_edit.html?uuid={uuid}',
                url: _ctx + '/json/product/detail.json?uuid={uuid}',
                buttonsGroup: [
                    {
                        text: '更新',
                        url: _ctx + '/json/response/success.json',
                        iconCls: 'fa fa-save',
                        handler: 'ajaxForm',
                        btnCls: 'topjui-btn'
                    }
                ]
            }">编辑</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'doAjax',
       extend: '#userDg-toolbar',
       btnCls:'topjui-btn-normal',
       iconCls:'fa fa-trash',
       url:_ctx + '/json/response/success.json',
       grid: {uncheckedMsg:'请先勾选要删除的数据',param:'uuid:uuid,code:code'}">删除</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'filter',
       extend: '#userDg-toolbar',
       btnCls:'topjui-btn-warm'">过滤</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'search',
       extend: '#userDg-toolbar',
       btnCls:'topjui-btn-danger'">查询</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'export',
       extend: '#userDg-toolbar',
       btnCls:'topjui-btn',
       url:_ctx + '/json/response/export.html'">导出</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'openTab',
       btnCls:'topjui-btn-normal',
       tab:{
           title:'这是新的Tab窗口',
           href:_ctx + '/html/menu/openTab_index.html'
       }">打开Tab窗口</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'openWindow',
       extend: '#userDg-toolbar',
       btnCls:'topjui-btn-warm',
       href:'http://www.topjui.com?uuid={uuid}'">打开新窗口</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="method:'request',
       btnCls:'topjui-btn',
       url:_ctx + '/json/response/success.json'">执行普通请求</a>
    <a href="javascript:void(0)"
       data-toggle="topjui-menubutton"
       data-options="menu:'#exportSubMenu',
       btnCls:'topjui-btn-danger',
       hasDownArrow:true,
       iconCls:'fa fa-list'">更多</a>
    <div id="exportSubMenu" class="topjui-toolbar" style="width:150px;">
        <div data-toggle="topjui-menubutton"
             data-options="method:'request',
             extend: '#userDg-toolbar',
             url:_ctx + '/json/response/success.json?uuid={uuid}'">导出 PDF 报表
        </div>
        <div data-toggle="topjui-menubutton"
             data-options="method:'export',
             extend: '#userDg-toolbar',
             url: _ctx + '/json/response/export.html'">导出EXCEL列表
        </div>
        <div data-toggle="topjui-menubutton"
             data-options="method:'request',
             extend: '#userDg-toolbar',
             url:_ctx + '/json/response/success.json?uuid={uuid}'">导出EXCEL报表
        </div>
        <div data-toggle="topjui-menubutton"
             data-options="method:'request',
             extend: '#userDg-toolbar',
             url:_ctx + '/json/response/success.json?uuid={uuid}'">导出WORD报表
        </div>
    </div>
</div>
<!-- 表格工具栏结束 -->
</body>
</html>