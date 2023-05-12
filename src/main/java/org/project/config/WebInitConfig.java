package org.project.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
/**
 * @author jackqiu
 */
//web配置类
public class WebInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载Spring配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //加载SpringMVC配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    //  "/"   使tomcat拦截所有请求，来进行处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //1.乱码处理
    //getServletFilters：Servlet的过滤器的实现
    //解决全站乱码问题，处理所有的请求
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
    /*
    老版：
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    protected webApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register( SpringMvcConfig.class);
        return ctx;
    }

    protected webApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        return ctx;
    }

    protected String[] getServletMappings() {
        return new String[]["/"];
    }

}
    */
}
