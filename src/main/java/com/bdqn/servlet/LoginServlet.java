// Servlet Annotated Class.java模板(带注解的Servlet)

package com.bdqn.servlet;

import com.bdqn.entity.NewsUsers;

import com.bdqn.service.LoginService;
import com.bdqn.service.serviceImpl.LoginServiceImpl;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @ClassName LoginServlet
 * @Author Administrator
 * @Date 2019/6/26 9:08
 * @Version V1.0
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
       // request.setCharacterEncoding("UTF-8");  // 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题

        // response.getWriter().write("你好 servlet!");
        String opr=request.getParameter("opr");
        if(opr==null){
            opr="login";
        }
        if("login".equals(opr)){


            String uname = request.getParameter("uname");
            String upwd = request.getParameter("upwd");
            NewsUsers users=new NewsUsers();
            users.setUname(uname);
            users.setUpwd(upwd);
            LoginService loginService=new LoginServiceImpl();
            int x=loginService.login(users);
            if(x==-1){
                request.setAttribute("x",x);
                request.getRequestDispatcher("/index.jsp").forward(request,response);

            }else  if (x==0){
                HttpSession session = request.getSession();
                session.setAttribute("uname",uname);
                request.setAttribute("x",x);
                System.out.println(request.getServletContext().getAttribute("uCount"));
                request.getRequestDispatcher("/index.jsp").forward(request,response);


            }else  if (x==1){

                request.setAttribute("uname",uname);
                request.getRequestDispatcher("/newspages/admin.jsp").forward(request,response);
            }

        }else if ("out".equals(opr)){
            HttpSession session=request.getSession();
            session.removeAttribute("uname");

        }

    }
}