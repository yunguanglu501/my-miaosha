package com.example.miaosha.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 19:24
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return interceptor;
//    }

//    @Bean
//    SqlSessionFactoryBean sqlSessionFactoryBean(SqlSessionFactoryBean sqlSessionFactoryBean,MybatisPlusInterceptor mybatisPlusInterceptor){
//        sqlSessionFactoryBean.setPlugins(mybatisPlusInterceptor);
//        return sqlSessionFactoryBean;
//    }

    @Bean
    PageInterceptor pageHelper() {
        //分页插件
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageInterceptor});
        return pageInterceptor;
    }
}
