function getContextPath() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}


function clickTreeNode()
{//管理员页面，点击左侧树，在中部添加tab，并显示相应的管理表格
	$('#mytree').tree({
	onClick: function(node){
//		alert(node.text);  // 在用户点击的时候提示
//	     $('#mytab1').tabs('add',{title:node.text,closable:true,padding:10});
                 var title = node.text;  
                    if(title=="用户管理"){  
                         var url = "usermanagement.jsp" ;                  
                         addTab(title, url) ;
                        
                    }else if(title=="文件管理"){  
                         var url = "${pageContext.request.contextPath}/upload.jsp" ;      
                         addTab(title, url) ;
                         
                    }     
                    else if(title=="基于jsp的文件上传下载"){  
                         var url = "${pageContext.request.contextPath}/easyUIFileM.jsp" ;     
                         addTab(title, url) ; 
                         
                    }                     
                    else{  
                        alert("功能模块未开发");  
                    }                           
                } 
                
      });
      
}
            //添加选项卡  
            function addTab(title, url){                  
                    content = '<iframe scrolling="auto" frameborder="0"  src="' + url+ '" style="width:100%;height:100%;"></iframe>';  
                    if(!$("#mytab1").tabs('exists', title)){  
                        $("#mytab1").tabs("add", {  
                     title : title,  
                     closable :  true,  
                     content : content,  
                     width: $('#mainPanle').width() ,  
                     height: $('#mainPanle').height()  
                    } );                   
                }else{  
                     $('#mytab1').tabs('select', title);  
                }            
            }  
              
             function tabClose() {  
               /*双击关闭TAB选项卡*/  
               $(".tabs-inner").dblclick(function () {  
                   var subtitle = $(this).children("span").text();  
                   $('#mytab1').tabs('close', subtitle);
                   
               })  
   
               $(".tabs-inner").bind('contextmenu', function (e) {  
                   $('#mm').menu('show', {  
                       left: e.pageX,  
                       top: e.pageY 
                   });  
                   var subtitle = $(this).children("span").text();  
                   $('#mm').data("currtab", subtitle);  
                   return false;  
               });  
           }  
   
          
      
//function deleteUser(){//删除用户
//	var row = $('#usertable').datagrid('getSelected');
//    if (row){
//    	$.messager.confirm('确认', '是否确认删除该用户?', function (r) {  
//            $.ajax({  
//                type: "post",  
//                url: "/Share_system/user/deleteUserById.do",  
//                data: 
//  			    {
//                  	"user_id":row.user_id
//                 },  
//                success: function (result) {  
//                    if (result.success) {  
//                        $.messager.alert("提示", "删除成功！", "info");  
//                        $('#usertable').datagrid('reload');
////                        getAllData();  
//                    }  
//                    else {  
//                        $.messager.alert("错误", result.Msg, "info");  
//                    }  
//                },  
//                dataType: "json"  
//            });  
////        	alert('User ID:'+row.user_id);
//    });  
//   }
//   else{
//   	$.messager.confirm('提示', '请先选择要删除的行')
//   }
//   
//	
//}


