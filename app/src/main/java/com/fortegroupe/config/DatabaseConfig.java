package com.fortegroupe.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortegroupe.dao.UserDao;
import com.fortegroupe.dao.implementation.UserDaoImpl;
import com.fortegroupe.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by sazzad on 9/7/15
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Autowired
    private ApplicationContext appContext;



    @Bean(name = "DataSource")
    public HikariDataSource dataSourceWinMacLinux() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("databaseName", "user_accounts");
        dataSource.addDataSourceProperty("portNumber", "3306");
        dataSource.addDataSourceProperty("serverName", "127.0.0.1");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "root");
        return dataSource;

    }
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
        localSessionFactoryBean.setAnnotatedClasses(
                User.class);

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }


    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
