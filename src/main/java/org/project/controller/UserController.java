package org.project.controller;

import org.project.domain.User;
import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public String login(User user1,HttpSession session,Model model){//1. 获取用户名和密码  --> User user1
        User user = userService.login(user1.getUsername(), user1.getPassword());//2. 调用service查询
        if(user != null){//3. 判断
            /*if("1".equals(remember)){//判断用户是否勾选记住我
                Cookie c_username = new Cookie("username",username); //勾选了，发送Cookie
                Cookie c_password = new Cookie("password",password);//1. 创建Cookie对象
                c_username.setMaxAge( 60 * 60 * 24 * 7);// 设置Cookie的存活时间
                c_password.setMaxAge( 60 * 60 * 24 * 7);
                response.addCookie(c_username);//2. 发送
                response.addCookie(c_password);
            }*/

            session.setAttribute("user",user);//将登陆成功后的user对象，存储到session
            return "redirect:/mainView";
        }else {
            model.addAttribute("login_msg","用户名或者密码错误");
            return "login.jsp";//String contextPath = request.getContextPath();
        }
    }

    @RequestMapping("/user/register")
    public String register(User user, Model model){
        //1. 获取用户名和密码  --> User user1
        boolean flag = userService.register(user);//2. 调用service 注册
        if(flag){//3. 判断注册成功与否     String contextPath = request.getContextPath();
            model.addAttribute("register_msg","注册成功，请登录");
            return "login.jsp";//注册成功，跳转登陆页面
        }else {
            model.addAttribute("register_msg","注册失败，用户名已存在");
            return "register.jsp";//注册失败，跳转到注册页面
        }
    }

    @RequestMapping("/user/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "login.jsp";
    }

    /*@RequestMapping("/test")
    public String notFound(){
        return "/WEB-INF/study.html";
    }*/
}

