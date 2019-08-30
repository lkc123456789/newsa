
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.6.1.js"></script>
    <script type="text/javascript">
        $(function () {
           page(1);

           $("#firstPage").click(function () {
               page(1);
           })
            $("#lastPage").click(function () {
                page($("#pageCount").text());
            })
            $("#backPage").click(function () {
                page($("#pageNum").text()-1);
            })
            $("#nextPage").click(function () {
                page(parseInt($("#pageNum").text())+1);
            })
            function page(pageNum) {
                $.getJSON("/TestServlet","opr=selectAll&pageNum="+pageNum,callBack);
                function callBack(data) {
                    $("#uId").empty()
                    $(data.page.list).each(function () {

                        $("#uId").append("            <li>\n" +
                            "                <a href='/TestServlet?opr=selectById&id="+this.nid+"'>"+this.ntitle+"</a>\n" +
                            "                    <span>"+this.ncreateDate+"</span>\n" +
                            "                    </li>")
                    })
                    $("#pageNum").text(data.page.pageNum);
                    $("#pageCount").text(data.page.pageCount);


                    $(data.list1).each(function () {
                        $("#chainId").append("<li><a href='/TestServlet?opr=selectById&id="+this.nid+"'><b>"+this.ntitle+"</b></a></li>")
                    })
                    $(data.list2).each(function () {
                        $("#foreignId").append("<li><a href='/TestServlet?opr=selectById&id="+this.nid+"'><b>"+this.ntitle+"</b></a></li>")
                    })
                    $(data.list3).each(function () {
                        $("#palyId").append("<li><a href='/TestServlet?opr=selectById&id="+this.nid+"'><b>"+this.ntitle+"</b></a></li>")
                    })
                }
            }


        })



    </script>
    <script>
        $(function () {
            var x="${x}";

            if(x=="-1"){
                alert("用户名或密码错误")
            }else if(x=='0') {
              //  alert(1111111)
                $("#fId").hide();
                $("#dId").show();


            }
            $("#bId").click(
                function () {
                $.get("/LoginServlet","opr=out",callBack)
            })
            function callBack() {
                alert("注销成功!");
                $("#fId").show();
                $("#dId").hide();
            }
        })

    </script>
</head>

<body onload="focusOnLogin()">
  
<div id="header">
  <div id="top_login">
    <form action="/LoginServlet" method="post" id="fId">
      <input type="hidden" name="opr" value="login"/>
      <label> 登录名 </label>
      <input type="text" name="uname" value="" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" value="" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
      <div id="dId" style="display: none">
          ${uname}欢迎您！您是第${uCount}位登录用户&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="button"value="注销" id="bId">
      </div>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">

<%@include file="/index-elements/index_sidebar.jsp"%>
 
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <a href=""><b>新闻主题</b></a>
      <ul class="classlist">

            <li>
            <a href=''>新闻标题</a>
            <span>创建时间</span>
            </li>
      </ul>
          <ul class="classlist" id="uId">


          </ul>
          <p align="center"> 当前页数:[<span id="pageNum"></span>]&nbsp;
              总页数:[<span id="pageCount"></span>]&nbsp;
          <a href="javascript:;" id="firstPage">首页</a>&nbsp;
          <a href="javascript:;" id="backPage">上一页</a>

          <a href="javascript:;" id="nextPage">下一页</a>
          <a href="javascript:;" id="lastPage">末页</a>
          </p>
      </ul>
    </div>
    <%@ include file="index-elements/index_rightbar.jsp"%>
  </div>
</div>
  <%@ include file="index-elements/index_bottom.jsp"%>
</body>
</html>
