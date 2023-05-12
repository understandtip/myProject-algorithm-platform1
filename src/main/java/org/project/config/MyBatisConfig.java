package org.project.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    //配置sqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){//dataSource 为自动装配的
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("org.project.domain");
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
