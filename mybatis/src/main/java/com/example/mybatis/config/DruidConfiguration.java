package com.example.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @ClassName DruidConfiguration
 * @Author nihui
 * @Date 2019/4/21 21:29
 * @Version 1.0
 * @Description TODO
 */
@Configuration
public class DruidConfiguration {
    private Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1"); // IP 白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", "192.168.31.234"); // IP 黑名单 (存在共同时，deny 优先于 allow)
        registrationBean.addInitParameter("loginUsername", "admin"); // druid 监控页面登陆用户名
        registrationBean.addInitParameter("loginPassword", "123456"); // druid 监控页面登陆密码
        registrationBean.addInitParameter("resetEnable", "false"); // 禁用 HTML 页面上的“Reset All”功能
        return registrationBean;

    }

    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"); // 忽略资源
        return registrationBean;
    }

    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.username}") String userName,
                                      @Value("${spring.datasource.password}") String password,
                                      @Value("${spring.datasource.maxActive}") int maxActive,
                                      @Value("${spring.datasource.filters}") String filters,
                                      @Value("${spring.datasource.initialSize}")
                                              int initialSize,
                                      @Value("${spring.datasource.minIdle}")
                                              int minIdle,
                                      @Value("${spring.datasource.maxWait}")
                                              int maxWait,
                                      @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
                                              int timeBetweenEvictionRunsMillis,
                                      @Value("${spring.datasource.minEvictableIdleTimeMillis}")
                                              int minEvictableIdleTimeMillis,
                                      @Value("${spring.datasource.validationQuery}")
                                              String validationQuery,
                                      @Value("${spring.datasource.testWhileIdle}")
                                              boolean testWhileIdle,
                                      @Value("${spring.datasource.testOnBorrow}")
                                              boolean testOnBorrow,
                                      @Value("${spring.datasource.testOnReturn}")
                                              boolean testOnReturn,
                                      @Value("${spring.datasource.poolPreparedStatements}")
                                              boolean poolPreparedStatements,
                                      @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
                                              int maxPoolPreparedStatementPerConnectionSize,
                                      @Value("${spring.datasource.connectionProperties}")
                                              String connectionProperties,
                                      @Value("${spring.datasource.useGlobalDataSourceStat}")
                                              boolean useGlobalDataSourceStat
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        /*数据源补充配置*/
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
