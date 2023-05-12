package org.project.controller;

import org.project.domain.Blog;
import org.project.domain.Forward;
import org.project.domain.User;
import org.project.domain.ubFavorite;
import org.project.service.BlogService;
import org.project.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/blog")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/isFavorite")
    public Boolean isFavorite(@RequestParam("bid")String bid,HttpSession session){//1. 获取博客id
        User user = (User)session.getAttribute("user");//2. 获取当前登录的用户 user
        int id;//用户id
        if(user == null){   id = 0;   }//用户尚未登录
        else{   id = user.getId();    }//用户已经登录
        return favoriteService.isFavorite(bid, id);//3. 调用FavoriteService查询是否收藏//4. 写回客户端
    }
    /*  添加收藏  */
    @RequestMapping("/addFavorite")
    public Boolean addFavorite(@RequestParam int bid,HttpSession session){
        User user = (User) session.getAttribute("user");//2. 获取当前登录的用户
        int id = user.getId(); //获取用户id
        ubFavorite ubfavorite = new ubFavorite(bid,1,id);
        favoriteService.add(ubfavorite);//3. 调用service添加 //4.给客户端浏览器一个添加成功的响应
        return true;
    }
    @RequestMapping("/login")
    public String login(HttpSession session){
        return ((User) session.getAttribute("user")).getUsername();
    }

    @RequestMapping("/forwardTo")
    public Boolean forwardTo(@RequestParam("bid") String _bid){
        int bid = Integer.parseInt(_bid);
        Forward forward = favoriteService.select();//查询当前表的数据
        int bbid = forward.getBid();
        int ffid = forward.getFid();
        Forward forward1 = new Forward(bid,bid);//更新当前表的数据
        favoriteService.update(forward1,bbid,ffid);
        return true;
    }
    //查询出当前选择的问题的信息
    @RequestMapping("/selectBlog")
    public Blog selectBlog(){
        Forward forward = favoriteService.select();
        int bid = forward.getBid();
        return blogService.selectById(bid);
    }
}
