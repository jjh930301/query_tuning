package com.query.example.configs;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.query.example.constant.Constant;

@Configuration
@MapperScan(
  basePackages = "com.query.example.mapper",
  sqlSessionFactoryRef = "exampleMybatisSqlSessionFactory"
)
public class ExampleMybatisConfig {
  @Bean(name = "exampleMybatisDatasource")
  public DataSource dataSource() {
    PooledDataSource dataSource = new PooledDataSource();
    dataSource.setDriver("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://"+Constant.DB_URI+":3306/"+Constant.DB_NAME+"?characterEncoding=UTF-8");
    dataSource.setUsername(Constant.DB_USER);
    dataSource.setPassword(Constant.DB_PASSWORD);
    return dataSource;
  }

  private Resource[] resolveMapperLocations() throws Exception {
    PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    return resourcePatternResolver.getResources("classpath*:mapper/example/*.xml");
}

  @Bean(name = "exampleMybatisSqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setMapperLocations(resolveMapperLocations());
    return factoryBean.getObject();
  }  
}
