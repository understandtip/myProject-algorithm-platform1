package org.project.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;

import javax.sql.DataSource;
import java.util.Properties;

public class MyBatisConfig {
    //配置sqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){//dataSource 为自动装配的
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("org.project.domain");
        //设置xml配置文件路径
        //factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);//设置settings里的mapUnderscoreToCamelCase属性 将下划线映射为驼峰
        factoryBean.setPlugins(new Interceptor[]{new PageInterceptor()});//设置分页插件
        return factoryBean;
    }
    //配置mapperScanner(dao)
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("org.project.mapper");
        return msc;
    }

}
