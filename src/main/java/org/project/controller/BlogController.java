package org.project.controller;


import org.project.domain.*;
import org.project.service.BlogService;
import org.project.service.FavoriteService;
import org.project.controller.Myutill.MyClassLoader;
import org.project.controller.Myutill.MyCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/selectAll")
    public List<Blog> selectAll(){
        return blogService.selectAll();
    }

    @GetMapping("/add")
    public Boolean add(@RequestBody Blog blog){
        blogService.add(blog);//2. 调用service添加
        return true;//3. 响应成功的标识
    }

    /*  批量删除  */
    @RequestMapping("/deleteByIds")
    public Boolean deleteByIds(@RequestParam int[] ids){
        blogService.deleteByIds(ids);//2. 调用service
        return true;//3. 响应成功的标识
    }

    /*  分页查询  */
    //1. 接收 当前页码 和 每页展示条数  url?currentPage=1&pageSize=5
    @RequestMapping("/selectByPage")
    public PageBean<Blog> selectByPage(@RequestParam("currentPage")int currentPage,
                                       @RequestParam("pageSize")int pageSize){
        return blogService.selectByPage(currentPage,pageSize);//2. 调用service查询
    }

    /**
     * 分页条件查询
     */
    //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
    @RequestMapping("/selectByPageAndCondition")
    public PageBean<Blog> selectByPageAndCondition(@RequestBody Blog blog,
                                                   @RequestParam("currentPage")int currentPage,
                                                   @RequestParam("pageSize")int pageSize){
        return blogService.selectByPageAndCondition(currentPage,pageSize,blog);//2. 调用service查询
    }

    @RequestMapping("/selectById")
    public void selectById(@RequestParam String id){//1. 接收id
        /*Blog blog = blogService.selectById(Integer.parseInt(id));//2. 调用service查询
        request.setAttribute("blog",blog);//3. 存储到request中
        request.getRequestDispatcher("/update.jsp").forward(request,response);//4. 转发到update.jsp*/
    }

    /*  删除功能  *//* get请求 */
    @RequestMapping("/delete")
    public Boolean delete(@RequestParam("id")int deleteId){
        blogService.delete(deleteId);//4.调用service的delete方法
        return true;//5.给客户端浏览器一个添加成功的响应
    }

    /*  修改功能  */
    @RequestMapping("/update")
    public Boolean update(@RequestBody Blog blog){
        blogService.update(blog);//4.调用service的add方法
        return true;//5.给客户端浏览器一个添加成功的响应
    }

    @RequestMapping("/test1")
    public String test1(@RequestBody RuleForm ruleForm ){//3.将json数据转为RuleForm对象
        String endResult = "";
        String contents = ruleForm.getContents();//String contents = request.getParameter("contents");
        MyClassLoader myClassLoader = new MyClassLoader();
        try {//拦截
            Boolean result1 = MyCompiler.compile("Main", contents);//编译Main.class    即：修改Test.class文件
            /*if (result1) { System.out.println("Compile it successfully."); }//如果result==true,返回Compile it successfully.*/
            ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024); //拦截系统输出流     将结果存放到result中去
            PrintStream cacheStream = new PrintStream(baoStream);//临时输出
            PrintStream oldStream = System.out;//缓存系统输出
            System.setOut(cacheStream);//
            Forward forward = favoriteService.select();//获取测试用例的输入输出
            int bid = forward.getBid();
            Blog blog = blogService.selectById(bid);//
            String input = blog.getInput();
            Writer fw = new FileWriter("D:\\BaiduNetdiskDownload\\workSpace\\myProject\\data.txt"); //定义缓冲字符输出管道与目标文件接通
            fw.write(input);//改data.txt内容为输出
            fw.close();
            //System.out.print("3 4\n");//不会打印到控制台
            Class c = myClassLoader.loadClass("Main");//获取Main.class
            Method method = c.getMethod("main", String[].class);//获取main方法
            method.invoke(null, new Object[]{new String[]{}});//运行main函数
            String result = baoStream.toString();
            System.setOut(oldStream);//还原到系统输出
            String a = blog.getOutput();  //设置a为输出用例的数据//System.out.println(result);
            if(result1){ //判断输出用例的结果   与    测试用例是否相等
                if(result.equals(a+"\r\n")){
                    endResult = "true";
                }else{
                    endResult = "false";
                }
            }
            else{
                endResult = "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endResult;
    }
}
