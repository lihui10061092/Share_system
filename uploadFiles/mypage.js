
// var contextPa = $contextPath;
function getContextPath() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

     var pageIndex = 1;      // 当前页数
      $(function(){
          GetPageCount();// 获取分页数量以及总的记录条数
         $("#load").hide();// 隐藏loading提示
        $("#template").hide();// 隐藏模板
          ChangeState(0,1);// 设置翻页按钮的初始状态
       
        bind();// 绑定第一页的数据
       
        // 第一页按钮click事件
        $("#first").click(function(){
            pageIndex = 1;
            ChangeState(0,1);
            bind();   
        });
       
        // 上一页按钮click事件
        $("#previous").click(function(){
            pageIndex -= 1;
            ChangeState(-1,1);           
            if(pageIndex <= 1){
                pageIndex = 1;
                ChangeState(0,-1);
            }
            bind();   
        });
      
        // 下一页按钮click事件
        $("#next").click(function(){
            pageIndex += 1;
            ChangeState(1,-1);
            if(pageIndex>=pageCount)
            {
                pageIndex = pageCount;
                ChangeState(-1,0);
            }
            bind(pageIndex);           
        });
       
        // 最后一页按钮click事件
        $("#last").click(function(){
            pageIndex = pageCount;
            ChangeState(1,0);
            bind(pageIndex);           
        });            
        // 每页显示记录条数select事件
        $("#pageSize").change(function(){
             bind();
        })
    });
   
    // AJAX方法取得数据并显示到页面上
    function bind(){
        $("#load").show();
        var pageSize = $("#pageSize").val();
        $.ajax({
            type: "get",// 使用get方法访问后台
            dataType: "json",// 返回json格式的数据
            url: getContextPath() + "/share/queryShareByPage.do",// 要访问的后台地址
            data: "pageIndex=" + pageIndex+"&pageSize="+pageSize,// 要发送的数据
            complete : function(msg){// msg为返回的数据，在这里做数据绑定
                $("[id=ready]").remove();
                var data = eval("("+msg.responseText+")");
                $.each(data, function(i, n){
                    var row = $("#template").clone();
                    row.find("#userId").text(n.userId);
                    row.find("#userName").text(n.userName);
                    row.find("#depId").text(n.depId);
                    row.find("#createTime").text(n.createTime);
                    if(n.createTime !== undefined) row.find("#createTime").text(n.createTime);
                    row.find("#creator").text(n.creator);
                    row.find("#menusId").text(n.menusId);
                    row.find("#isValid").text(n.isValid);
                                      
                    row.attr("id","ready");// 改变绑定好数据的行的id
                    row.appendTo("#datas");// 添加到模板的容器中
                });
                $("[id=ready]").show();
                SetPageInfo();
            }
        });
    }
    function ChangeDate(date){
         return date.replace("-","/").replace("-","/");
    }
    // 设置第几页/共几页的信息
    function SetPageInfo(){
        var pageCount = $("#pageCount").val();
        var totalCount = $("#totalCount").val();
        var pageSize = $("#pageSize").val();
      $("#pageinfo").html(" 第<input class='default_pgCurrentPage' id='pageIndex' type='text' value='"+pageIndex+
      "' style='width: 30px'  /> 页" + "/" +"共 "+pageCount+"页"+
      "  检索到 "+totalCount+"条记录，显示第 "+(pageIndex*pageSize-pageSize)+" 条 - 第 "+(pageIndex*pageSize)+" 条记录");
    }
    // AJAX方法取得分页总数
    function GetPageCount(){
        var pageSize = $("#pageSize").val();
        $.ajax({
            type: "get",
            dataType: "text",
            url: getContextPath() + "/share/getPageCount.do",
            data: "pageSize="+pageSize ,
            async: false,
            success: function(msg){
                var data = eval("("+msg+")");
                $("#pageCount").val(data[0].pageCount);
                $("#totalCount").val(data[0].totalCount);
            }
        });
    }
 