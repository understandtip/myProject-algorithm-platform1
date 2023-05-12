package org.project.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String contentType = request.getHeader("Content-Type");
//        HandlerMethod hm = (HandlerMethod)handler;
//        System.out.println("preHandle...222");
        HttpServletRequest req = (HttpServletRequest) request;
        boolean flag = true;
        String[] urls = {"/pages"};
        String url = req.getRequestURL().toString(); // 获取当前访问的资源路径
        for (String u : urls) {//循环判断
            if(url.contains(u)){
                req.getRequestDispatcher("/pages/notFound.html").forward(req,response);
                flag = false;//找到了 :放行
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle...222");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion...222");
    }
}
