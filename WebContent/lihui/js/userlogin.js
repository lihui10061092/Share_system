document.onkeydown = function(e){
    var event = e || window.event;  
    var code = event.keyCode || event.which || event.charCode;
    if (code == 13) {
        login();
    }
}
//var contextPa = $contextPath;
$(function(){
    $("input[name='login']").focus();
});
function cleardata(){
    $('#loginForm').form('clear');
}

function getContextPath() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

//function userLogin(){
//	$('#loginForm').action(getContextPath() + "/user/userlogin.do");
//}

function userLogin(){
//	var userData={};
	var loginName=$("input[name='login']").val();
	var password=$("input[name='password']").val();
     if(loginName==""){
         $("#showMsg").html("用户名为空，请输入");
         $("input[name='login']").focus();
    }else if(password==""){
    	 $("#showMsg").html("密码为空，请输入");
         $("input[name='password']").focus();
    }
    else{
        //ajax异步提交  
    	//${pageContext.request.contextPath}
           $.ajax({ 
//           	      data:jQuery.toJSON(userData),
                  type:"POST",   //post提交方式默认是get
//                  data: '{loginName:' + loginName + ',password:' + password + '}',
                  data:
                  {
                  	"loginName":loginName,
                  	"password":password
                  },
                  dataType: 'json',
                  url: getContextPath() + "/user/userlogin.do", 
//                  data:$("#loginForm").serialize(),   //序列化      
                  error:function(request) {      // 设置表单提交出错                 
                      $("#showMsg").html(request);  //登录错误提示信息404?
                      document.location= getContextPath() + "/lihui/jsp/userlogin.jsp";
                  },
                  success:function(data) {
                  	if(data.success)
                  	{
//                  		alert("登录成功，正在为您跳转！");
                  		$.messager.show({
							title : 'Success!',
							msg : '登录成功！',
							style:{
                            left:800, // 与左边界的距离
                            top:450 // 与顶部的距离
                            }
                         });
                         //设置在当前页面停留2秒再进行跳转，解决提示框显示时间过短的问题
                        window.setTimeout('document.location= getContextPath() + "/lihui/jsp/homepage.jsp"',2000); 
                  	}
                  	else
                  	{
//                  		alert("登录失败，请重试！");
                  		$.messager.show({
							title : 'Fail!',
							msg : '用户名或密码错误，请重试！',
							style:{
                            left:800, // 与左边界的距离
                            top:450 // 与顶部的距离
                            }
                         });
                        window.setTimeout('document.location= getContextPath() + "/lihui/jsp/userlogin.jsp"',2000);
//                  		document.location= getContextPath() + "/lihui/jsp/userlogin.jsp";
                  	}
                  }            
            });       
        } 
}