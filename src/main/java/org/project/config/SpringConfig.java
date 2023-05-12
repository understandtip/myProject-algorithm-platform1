package org.project.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//设置为配置类
@ComponentScan({"org.project.service","org.project.mapper"})//扫描service包
@PropertySource("classpath:jdbc.properties")//连接数据库的信息
@Import({JdbcConfig.class,MyBatisConfig.class})//导入JdbcConfig,MyBatisConfig两个配置
@EnableAspectJAutoProxy//开启AOP的注解
@EnableTransactionManagement//事务：3.开启注解式事务驱动
/*
       //@ComponentScan({"org.project.service","org.project.mapper"})的另一种方式
@ComponentScan(value="com.itheima" ,
excludeFilters = @Componentscan .Filter(
type = FilterType.ANNOTATION,
classes = Controller.class
)
*/
public class SpringConfig {
}
