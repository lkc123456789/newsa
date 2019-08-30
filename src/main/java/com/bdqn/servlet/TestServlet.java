// Servlet Annotated Class.java模板(带注解的Servlet)

package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.IndexAll;
import com.bdqn.entity.News;
import com.bdqn.entity.Page;
import com.bdqn.service.TestService;
import com.bdqn.service.serviceImpl.TestServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @ClassName TestServlet
 * @Author Administrator
 * @Date 2019/6/24 10:18
 * @Version V1.0
 */
@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
      //  request.setCharacterEncoding("UTF-8");  // 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
       // response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题

        // response.getWriter().write("你好 servlet!");
        String opr=request.getParameter("opr");

        TestService testService=new TestServiceImpl();
        if(Objects.equals(opr,"selectAll")){
            int pageNum=1;
            String pN=request.getParameter("pageNum");
            if(pN!=null){
                 pageNum=Integer.parseInt(pN);
            }

            int pageSize=5;
            Page page=new Page();
            page.setPageNum(pageNum);
            page.setPageSize(pageSize);

            IndexAll indexAll=testService.selectAll(page);
            String pageJSON =  JSON.toJSONStringWithDateFormat(indexAll,"yyyy-MM-dd HH:mm:ss");
            PrintWriter out=response.getWriter();
            out.print(pageJSON);
            out.flush();
            out.close();


        }else if(Objects.equals(opr,"selectById")){
            String id =request.getParameter("id");

            News news = testService.selectById(id);
            request.setAttribute("news",news);
            request.getRequestDispatcher("/newspages/news_read.jsp").forward(request,response);
        }

    }




}