package com.query.example.configs;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.query.example.constant.Constant;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
  basePackages = "com.query.example.repository",
  entityManagerFactoryRef = "exampleEntityManagerFactory", 
  transactionManagerRef = "exampleTransactionManager"
)
public class ExampleDatabaseConfig {

  @Primary
  @Bean(name = "exampleDataSource")
  public DataSource exampleDataSource() {

    return DataSourceBuilder.create()
      .url("jdbc:mysql://"+Constant.DB_URI+":3306/"+Constant.DB_NAME+"?characterEncoding=UTF-8")
      .username(Constant.DB_USER)
      .password(Constant.DB_PASSWORD)
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .build();
  }

  @Bean(name = "exampleEntityManagerFactory") 
  public LocalContainerEntityManagerFactoryBean exampleEntityManagerFactory(
    @Qualifier("exampleDataSource") DataSource dataSource
  ) { 
    try {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
    
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
          
      Map<String, Object> properties = new HashMap<>();
      properties.put("hibernate.hbm2ddlauto",System.getenv("hibernate.hbm2ddl.auto"));
      properties.put("hibernate.dialect",System.getenv("hibernate.dialect"));
      em.setPackagesToScan("com.query.example.entities");
      em.setJpaPropertyMap(properties);
      em.setJpaVendorAdapter(vendorAdapter);
      return em;
    } catch(Exception e) {
      e.printStackTrace(); 
      return null;
    }
    
  }

  @Bean(name = "exampleTransactionManager")
  public PlatformTransactionManager exampleTransactionManager( 
    @Qualifier("exampleEntityManagerFactory") EntityManagerFactory entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public JPAQueryFactory jpaQueryFactory(EntityManager
   entityManager) {
    return new JPAQueryFactory(entityManager);
  }
}
