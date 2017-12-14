
// var contextPa = $contextPath;
function getContextPath() {

	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}


// $(function(){
// var pager = $('#mytable').datagrid().datagrid('getPager'); // get the pager
// of datagrid
// pager.pagination({
// buttons:[{
// iconCls:'icon-search',
// handler:function(){
// alert('search');
// }
// },{
// iconCls:'icon-add',
// handler:function(){
// alert('add');
// }
// },{
// iconCls:'icon-edit',
// handler:function(){
// alert('edit');
// }
// }]
// });
// })

// data-options="rownumbers:true,singleSelect:true,pagination:true,url:'/Share_system/share/queryShareByPage.do',method:'get'"
// $(function(){
// $('#mytable').datagrid({
// title:'我的分享',
// iconCls:'icon-edit',//图标
// // width: 700,
// // height: 'auto',
// nowrap: false,
// striped: true,
// border: true,
// collapsible:true,//是否可折叠的
// // fit: true,//自动大小
// url:'/Share_system/share/queryShareByPage.do',
// //sortName: 'code',
// //sortOrder: 'desc',
// remoteSort:false,
// idField:'fldId',
// singleSelect:false,//是否单选
// pagination:true,//分页控件
// rownumbers:true,//行号
// frozenColumns:[[
// {field:'ck',checkbox:true}
// ]],
// toolbar: [{
// text: '添加',
// iconCls: 'icon-add',
// handler: function() {
// openDialog("add_dialog","add");
// }
// }, '-', {
// text: '修改',
// iconCls: 'icon-edit',
// handler: function() {
// openDialog("add_dialog","edit");
// }
// }, '-',{
// text: '删除',
// iconCls: 'icon-remove',
// handler: function(){
// delAppInfo();
// }
// }]
// });
// })
//    
// //设置分页控件
// var p = $('#mytable').datagrid('getPager');
// $(p).pagination({
// pageSize: 10,//每页显示的记录条数，默认为10
// pageList: [5,10,15],//可以设置每页记录条数的列表
// beforePageText: '第',//页数文本框前显示的汉字
// afterPageText: '页 共 {pages} 页',
// displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录'
// /*onBeforeRefresh:function(){
// $(this).pagination('loading');
// alert('before refresh');
// $(this).pagination('loaded');
// }*/
// });
			
$(function(){
			var pager = $('#mytable').datagrid().datagrid('getPager');//
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						addShare();
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});	
			})

		
		
	
			
function addShare(){
	$("#sharedialog").dialog({
        autoOpen: false,
        bgiframe: true,
        height:680,
        width:1080,
        title:"分享信息",
        modal:true,
        resizable:true
        });
        
   }
   
function closeDialog(){
	$("#sharedialog").dialog('close');
}
//增加分享方法，表单提交
function saveShare() {
	$('#addShareForm').form('submit', {
				url : getContextPath() + "/share/addshare.do",
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					//解析后台返回的JSON数据
					var result = eval('(' + result + ')');
//					var _result = result;
					if (!result.success) {
						$.messager.show({
							title : 'Error',
							msg : '添加失败！',
							style:{
                            left:800, // 与左边界的距离
                            top:450 // 与顶部的距离
                            }
					    });
					} else {
						$.messager.show({
							title : 'Success!',
							msg : '添加成功！',
							style:{
                            left:800, // 与左边界的距离
                            top:350 // 与顶部的距离
                            }
					});
					//关闭注册框
					$('#sharedialog').dialog('close'); // close the dialog
					}
				}
			});
//验证			

} 


