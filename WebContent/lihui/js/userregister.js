function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}

//上下文路径
var contextPath=getContextPath();

//登录界面注册按钮事件，使用Dialog.dialog()方法加载显示注册页面
function userRegister(){
	$("#mydialog").dialog({
        autoOpen: false,
        bgiframe: true,
        height:600,
        width:900,
        title:"注册信息",
        modal:true,
        resizable:true
        });
}
//关闭注册窗口方法
function closeDialog(){
	$("#mydialog").dialog('close');
}
//注册用户方法，表单提交
function saveUser() {
	$('#addUserForm').form('submit', {
				url : contextPath + "/user/addUser.do",
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
							msg : '该登录名已存在，请更换登录名',
							style:{
                            left:800, // 与左边界的距离
                            top:450 // 与顶部的距离
                            }
					    });
					} else {
						$.messager.show({
							title : 'Success!',
							msg : '注册成功！',
							style:{
                            left:800, // 与左边界的距离
                            top:350 // 与顶部的距离
                            }
					});
					//关闭注册框
					$('#mydialog').dialog('close'); // close the dialog
					}
				}
			});
//验证			

} 
