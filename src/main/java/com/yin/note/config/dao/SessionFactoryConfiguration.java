package com.yin.note.config.dao;
//将mybatis和dataSource回合到一起
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

//事务提交
@Configuration
public class SessionFactoryConfiguration {

    //myatis-config.xml配置文件的路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    //mybatis mapper文件所在路径
    @Value("${mapper_path}")
    private  String mapperPath;

    @Autowired
//    @Qualifier("datasource")
    private DataSource dataSource;//有时候会报错，不只有一个datasource，这时候用@Qualifier("datasource")解决

    //实体类所在的包
    @Value("${entity_package}")
    private String entityPachage;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean creatsqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean =
                new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //mybatis配置
        PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        //映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPachage);
        return sqlSessionFactoryBean;
    }
}
