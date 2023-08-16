package com.kzheng.boot.common.config;

import org.springframework.context.annotation.Configuration;

//不使用druid-spring-boot-starter，自定义时使用此配置
@Configuration
public class MyDataSourceConfig {
    //默认的自动配置是判断容器中没有才会配@ConditionOnMissingBean(DataSource.class)
    /*@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }*/
    /*@Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        return statViewServletServletRegistrationBean;
    }*/
}
