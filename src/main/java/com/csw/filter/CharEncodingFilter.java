package com.csw.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by HIAPAD on 2019/10/24.
 */
//自定义filter
public class CharEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("编码: " + encoding);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);//放行请求
    }

    @Override
    public void destroy() {

    }
}
