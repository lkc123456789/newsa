<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="/css/read.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="top_login">
    <label> 登录名 </label>
    <input type="text" id="uname" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="登录" onclick="login()"/>
    <label id="error"> </label>
    <a href="/index.jsp" class="login_link">返回首页</a> <img src="/images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="/images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="/images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <%@ include file="/index-elements/index_sidebar.jsp" %>
    <div class="main">
    <div class="class_type"> <img src="/images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${news.ntitle}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">作者：${news.nauthor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td align="left">发布时间：${news.ncreateDate}</td>
          </tr>          
          <tr>
            <td colspan="2" align="center">${news.nsummary}</td>
          </tr>
          <tr>
            <td colspan="2">${news.ncontent}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">

            <tr><td colspan="6"> 暂无评论！ </td></tr>
            <tr>
                <td colspan="6"><hr />
                </td>
            </tr>
                <tr>
                    <td> 留言人： </td>
                    <td></td>
                    <td> IP： </td>
                    <td>/td>
                    <td> 留言时间： </td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="6">内容</td>
                </tr>
                <tr>
                    <td colspan="6"><hr />
                    </td>
                </tr>

        </table>
      </ul>
      <ul class="classlist">
        <form action="" method="post">
          <input type="hidden" name="nid" value="" />
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td>

                  <input id="" name="cauthor" value="${uname}" readonly="readonly" style="border:0px;"/>


                IP：
                <input name="cip" id="cip" value="" readonly="readonly" style="border:0px;"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" id="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <tr><td><input name="submit" value="发  表" type="submit"/>
              </td></tr>
          </table>
        </form>
      </ul>
    </div>
  </div>
</div>
<%@ include file="../index-elements/index_bottom.jsp"%>
</body>
</html>
