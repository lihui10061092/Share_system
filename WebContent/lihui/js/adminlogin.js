function getContextPath() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}


function cleardata(){
    $('#adminLoginForm').form('clear');
}


function adminLogin(){
//	var userData={};
	var adName=$("input[name='adName']").val();
	var password=$("input[name='password']").val();
     if(adName==""){
         $("#showMsg").html("登录名为空，请输入");
         $("input[name='adName']").focus();
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
                  	"adName":adName,
                  	"password":password
                  },
                  dataType: 'json',
                  url: getContextPath() + "/admin/login.do",
                  success:function(data) {
                  	if(data.success)
                  	{
                         //设置在当前页面停留2秒再进行跳转，解决提示框显示时间过短的问题
                        window.setTimeout('document.location= getContextPath() + "/lihui/jsp/adminhomepage.jsp"',2000); 
                  	}
                  	else
                  	{
                        window.setTimeout('document.location= getContextPath() + "/lihui/jsp/adminlogin.jsp"',2000);
                  	}
                  }            
            });       
        } 
}

