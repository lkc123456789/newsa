package com.bdqn.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "EncFilter",urlPatterns = "/*")
public class EncFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, java.io.IOException {
        System.out.println("执行乱码过滤器");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        chain.doFilter(req, resp);

    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
