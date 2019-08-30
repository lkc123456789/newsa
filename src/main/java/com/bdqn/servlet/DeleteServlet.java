// Servlet Annotated Class.java模板(带注解的Servlet)

package com.bdqn.servlet;

import com.bdqn.service.DeleteService;
import com.bdqn.service.serviceImpl.DeleteServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.util.Objects;

/**
 * @Description TODO
 * @ClassName DeleteServlet
 * @Author Administrator
 * @Date 2019/6/28 11:50
 * @Version V1.0
 */
@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("UTF-8");  // 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题

        // response.getWriter().write("你好 servlet!");
        String opr=request.getParameter("opr");
        if(opr==null){
            opr="deleteById";

        }
        if(Objects.equals(opr,"deleteById")){
            String id = request.getParameter("id");
            DeleteService deleteService=new DeleteServiceImpl();
            int i =deleteService.deleteById(id);
            request.setAttribute("i",i);
            request.getRequestDispatcher("/newspages/admin.jsp").forward(request,response);
        }

    }
}