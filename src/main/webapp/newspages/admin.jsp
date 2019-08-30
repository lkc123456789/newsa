<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">;
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-1.6.1.js"></script>
    <script type="text/javascript">
      $(function () {
          $("#outId").click(
              function () {
                  $.get("/LoginServlet","opr=out",callBack)
              })
          function callBack() {
              alert("注销成功!");
              window.location.href="/index.jsp";


          }
          page(1)
          function page(pageNum) {
              $.getJSON("/TestServlet","opr=selectAll&pageNum="+pageNum,callBack1);
              function callBack1(data) {
                  $("#uId").empty();
                  $(data.page.list).each(function () {
                      $("#uId").append(" <li>"+this.ntitle+"\n" +
                          "            <span> 作者："+this.nauthor+" &#160;&#160;&#160;&#160;\n" +
                          "                <a href='/newspages/news_modify.jsp?id="+this.nid+"'>修改</a> &#160;&#160;&#160;&#160;\n" +
                          "                <a href='/DeleteServlet?opr=deleteById&id="+this.nid+"'>删除</a>\n" +
                          "            </span>\n" +
                          "        </li>");
                      $("#pageNum").text(data.page.pageNum);
                      $("#pageCount").text(data.page.pageCount);

                  })
              }
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
          }
          var  i="${i}";
          if(i=="1"){
              alert("删除成功!");
          }else if(i==-"1") {
              alert("删除失败！");
          }
      })



    </script>
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${uname} 登录  &#160;&#160;&#160;&#160; <a href="javascript:;" id="outId">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@ include file="console_element/left.html" %>
  <div id="opt_area">

    <ul class="classlist" id="uId">

	    <li>新闻标题
            <span> 作者： &#160;&#160;&#160;&#160;
                <a href='/newspages/news_modify.jsp'>修改</a> &#160;&#160;&#160;&#160;
                <a href=''>删除</a>
            </span>
        </li>

    </ul>
      <p align="center"> 当前页数:[<span id="pageNum"></span>]&nbsp;
          总页数:[<span id="pageCount"></span>]&nbsp;
          <a href="javascript:;" id="firstPage">首页</a>&nbsp;
          <a href="javascript:;" id="backPage">上一页</a>

          <a href="javascript:;" id="nextPage">下一页</a>
          <a href="javascript:;" id="lastPage">末页</a>
      </p>
  </div>
</div>
<div id="footer">
  <%@ include file="console_element/bottom.html" %>
</div>
</body>
</html>
