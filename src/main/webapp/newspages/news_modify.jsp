<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="console_element/top.jsp" %>

<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id=""> 编辑新闻： </h1>
    <form action="" method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid">

            <option value='' selected="selected">新闻主题</option>

        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" id="ntitle" type="text" class="opt_input" value=""/>
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" id="nauthor" type="text" class="opt_input" value=""/>
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" id="nsummary" cols="40" rows="3"></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" id="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" id="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
    <h1 id="opt_type">
		修改新闻评论：
	</h1>
      <table width="80%" align="left">

            <tr><td colspan="6"> 暂无评论！ </td></tr>
            <tr>
                <td colspan="6"><hr />
                </td>
            </tr>
       		<tr>
	          <td> 留言人： </td>
	          <td></td>
	          <td> IP： </td>
	          <td></td>
	          <td> 留言时间： </td>
	          <td></td>
	          <td><a href="">删除</a></td>
	        </tr>
	        <tr>
	          <td colspan="6">留言内容</td>
	        </tr>
	        <tr>
	          <td colspan="6"><hr />
	          </td>
	        </tr>
      </table>
  </div>
</div>
<%--
	request.removeAttribute("news");
	request.removeAttribute("topics");
--%>
<%@ include file="console_element/bottom.html" %>