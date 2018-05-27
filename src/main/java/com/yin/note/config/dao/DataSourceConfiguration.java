package com.yin.note.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

//spring初始化检索
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.yin.note.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private  String jdbcPassWord;

    //创建一个bean
    @Bean(name = "dataSource" )
    public ComboPooledDataSource creatDataSource() throws PropertyVetoException {
        //生成dataSource的实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassWord);
        //关闭连接后不自动提交false
        /*
        * 如果用到事务处理，就会用这个来设置是否默认自动提交回滚。意思是如果有多条sql语句放在一个事务里提交。
如果是true就会是这种情况：当其中某一条sql语句出现错误，事务会回滚之前的所有操作。就相当于不会执行此事务里的任何sql语句。
如果是false就会是这种情况：当其中某一条sql语句出错，事务不会回滚之前的任何操作，除非遇到中断型的错误就会结束。不然其它的sql语句会照常执行。
        *
        * */
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
