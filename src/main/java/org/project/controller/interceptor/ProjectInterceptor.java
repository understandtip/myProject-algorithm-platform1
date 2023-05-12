package org.project.controller.interceptor;

import org.project.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
//定义拦截器类，实现HandlerInterceptor接口
//注意当前类必须受Spring容器控制
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    //原始方法调用前执行的内容
    //返回值类型可以拦截控制的执行，true放行，false终止
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        Boolean flag = false;
        //判断访问资源路径是否和登录注册相关  "/imgs/","/css/",
        String[] urls = {"/user/login","/register","/user/register"};
        String url = req.getRequestURL().toString(); // 获取当前访问的资源路径
        for (String u : urls) {//循环判断
            if(url.contains(u)){
                flag = true;//找到了 :放行
            }
        }
        if(flag){
            flag = true;
        }else{
            HttpSession session = req.getSession(); //1. 判断session中是否有user
            User user = (User)session.getAttribute("user");
            if (user != null) {//2. 判断user是否为null
                flag = true;//登录过了  放行
            } else {
                req.setAttribute("login_msg", "您尚未登陆！");// 没有登陆，存储提示信息，跳转到登录页面
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, response);
            }
        }
        return flag;
    }

    @Override
    //原始方法调用后执行的内容
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle...");
    }

    @Override
    //原始方法调用完成后执行的内容
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion...");
    }
}
