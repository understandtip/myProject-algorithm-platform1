package org.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration//设置为配置类
@ComponentScan({"org.project.controller","org.project.config"})//组件加载：org.project.config 加载SpringMvcSupport.java
@EnableWebMvc//开启一些强大的功能
                        //例如 :1.将前端页面传递过来的json数据进行转换
                        //即：开启自动转换json数据的支持
                        //例如 :2.根据类型匹配对应的类型转换器
                        //相当于 <mvc:annotation-driven />
public class SpringMvcConfig {
}
