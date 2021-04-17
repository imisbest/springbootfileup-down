package com.csw.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HIAPAD on 2019/10/25.
 */
//自定义拦截器
public class MyInterceptor2 implements HandlerInterceptor {


    /**
     * 请求经过会先执行preHandler中方法如果这个方法返回为true 放行请求  如果为false中断请求
     */
    @Override
    //参数1:当前request  参数2:当前响应对象  参数3:当前方法访问控制器中方法对象
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {
        System.out.println("========2========");
        //System.out.println("method: "+method);
        /*Object o = request.getSession().getAttribute("user");
        if(o!=null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/index.jsp");*/
        return true;
    }

    //当controller执行完成之后会进入这个方法执行postHandler中内容
    @Override
    //参数1:request 参数2:response  参数3:当前访问方法对象  参数4:当前控制器方法返回的modelandview对象
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object method, ModelAndView modelAndView) throws Exception {
        //System.out.println("modeAndView: "+modelAndView);
        // if(modelAndView!=null){
        //    modelAndView.addObject("date",new Date());
        // }
        System.out.println("========3========");
    }

    //响应完成之后最后执行方法
    @Override
    //参数1:Request  参数2:response  参数3:当前访问方法对象 参数4:出现异常时异常对象  try catch  finally
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========5========");
        // System.out.println("异常信息: "+ex.getMessage());
    }
}
