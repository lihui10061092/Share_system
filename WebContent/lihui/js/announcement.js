document.onkeydown = function(e) {
	var event = e || window.event;
	var code = event.keyCode || event.which || event.charCode;
	if (code == 13) {
		login();
	}
}
//var contextPa = $contextPath;
$(function() {
			$("input[name='login']").focus();
		});

function getContextPath() {

	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}

function getAnnounceTitles() {
	$.ajax({
		type : "POST", //post提交方式，默认是get
		data : {},
		dataType : 'json',
		url : getContextPath() + "/announce/querytitles.do",

		success : function(data1) {
			//                  	var data = eval('(' + data + ')');
			if (data1.success) {
				var data = data1.data;
				var arry = data.result;
				//                  		var myUrl = getContextPath + "/lihui/jsp/announce.jsp";
				//遍历数组，取到数据动态创建DIV 或者li元素来显示
				for (var i = 0; i < arry.length; i++) {
					content = '<li> <a href=http://localhost:8080/Share_system/lihui/jsp/announce.jsp target="_Blank">'
							+ arry[i].a_title + "<a/></li>"
					$("#announces").append(content);
				}

				//                  		$div = $('#announces').children('div');

			} else {
				$.messager.show({
									title : 'Error!',
									msg : '查询公告失败！',
									style : {
										left : 800, // 与左边界的距离
										top : 450
										// 与顶部的距离
									}
								});
			}
		}

	});

}

function getAnnounces() {
	$.ajax({
				type : "POST", //post提交方式默认是get
				data : {},
				dataType : 'json',
				url : getContextPath() + "/announce/queryannounces.do",
				success : function(data1) {
					if (data1.success) {
						var data = data1.data;
						var arry = data.result;

						for (var i = 0; i < arry.length; i++) {
							//动态创建一个tr行标签,并且转换成jQuery对象
							var $trTemp = $("<tr></tr>");

							//往行里面追加 td单元格
							$trTemp.append("<td>" + arry[i].title + "</td>");
							$trTemp.append("<td>" + arry[i].content + "</td>");
							$trTemp.append("<td>" + arry[i].type + "</td>");
							// $("#J_TbData").append($trTemp);
							$trTemp.appendTo("#tb1");
						}

						//                  		$.messager.show({
						//							title : 'Success!',
						//							msg : '查询成功！',
						//							style:{
						//                            left:800, // 与左边界的距离
						//                            top:450 // 与顶部的距离
						//                            }
						//                         });

					} else {
						//失败提示
						$.messager.show({
									title : 'Error!',
									msg : '查询公告失败！',
									style : {
										left : 800, // 与左边界的距离
										top : 450
										// 与顶部的距离
									}
								});

					}
				}
			});
}
