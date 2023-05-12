package org.project.config;

import org.project.controller.interceptor.ProjectInterceptor;
import org.project.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

/**
 * 代替SpringMVC的配置文件：
 * 1、扫描组件   2、视图解析器     3、view-controller    4、default-servlet-handler
 * 5、mvc注解驱动    6、文件上传解析器   7、异常处理      8、拦截器
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;//拦截器,自动装配
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

//    @Override
//    //        放行静态资源
//    //        当访问/* * */ ????时候，走/* * *目录下的内容
//    //        addResourceHandlers ：添加资源过滤
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//        registry.addResourceHandler("/imgs/**").addResourceLocations("/imgs/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//        registry.addResourceHandler("/layui/**").addResourceLocations("/layui/");
////        registry.addResourceHandler("/**")
////                .addResourceLocations("classpath:/static/")
////                .addResourceLocations("classpath:/META-INF/resources/");
////        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//
//    }
    //8、拦截器
    //设置通过 ** 路径时运行此拦截器   拦截路径的访问
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        //registry.addInterceptor(projectInterceptor2).addPathPatterns("/**");
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(projectInterceptor).addPathPatterns("/**").excludePathPatterns("/");
    }

    //4、default-servlet-handler
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    //6、文件上传解析器
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        return viewResolver;
    }

    //3、view-controller
    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置首页
        registry.addViewController("/").setViewName("login.jsp");
        registry.addViewController("/register").setViewName("register.jsp");
        registry.addViewController("/mainView").setViewName("qqq-mainView.html");
        registry.addViewController("/study").setViewName("study.html");
        registry.addViewController("/blog").setViewName("blog.html");
        registry.addViewController("/questions").setViewName("questions.html");
        registry.addViewController("/answer").setViewName("answer.html");
        registry.addViewController("/answerDetails").setViewName("answer--details.html");
        //registry.addViewController("/pages/**").setViewName("/pages/notFound.html");
    }
/*
    //7、异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionMappings(prop);
        exceptionResolver.setExceptionAttribute("exception");
        resolvers.add(exceptionResolver);
    }               */

/*  //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setOrder(1);
        return viewResolver;
    }*/
}
