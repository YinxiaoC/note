package com.yin.note.config.dao.service;
//事务管理
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;

@Configuration
//开启事物管理
@EnableTransactionManagement
public class TransactionManagement implements TransactionManagementConfigurer {
   //注入dataSource
    @Autowired
    private DataSource dataSource;
    @Override
    //创建一个DataSourceTransactionManager的bean，然后注入dataSource的成员变量
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
