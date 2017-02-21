package com.aurora.config.data;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.aurora.data.repositories")
public class DataConfig {

	  @Bean
	  @Profile("development")
	  public DataSource devDataSource() {
	    EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
	    edb.setType(EmbeddedDatabaseType.H2);
	    edb.addScript("schema.sql");
	    edb.addScript("test-data.sql");
	    EmbeddedDatabase embeddedDatabase = edb.build();
	    return embeddedDatabase;
	  }

	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource);
	    emf.setPersistenceUnitName("report");
	    emf.setJpaVendorAdapter(jpaVendorAdapter);
	    
	    //emf.setPackagesToScan("com.aurora.model"); // For to user without persistence.xml
	    
	    // For create and drop tables
	    Properties ps = new Properties();
	    ps.put("spring.jpa.hibernate.ddl-auto", "create");
	    emf.setJpaProperties(ps);
	    
	    return emf;
	  }
	  
	  @Bean
	  @Profile("development")
	  public JpaVendorAdapter devJpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.H2);
	    adapter.setShowSql(true);
	    /*
	     * This NOT initialize data table structure (false)
	     * true -> enanle initialization
	     */
	    adapter.setGenerateDdl(true);
	    adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
	    return adapter;
	  }
	  
	  @Bean
	  @Profile("production")
	  public JpaVendorAdapter prodJpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.SQL_SERVER);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(true);
	    adapter.setDatabasePlatform("org.hibernate.dialect.SQLServerDialect");
	    return adapter;
	  }

	  @Configuration
	  @EnableTransactionManagement
	  public static class TransactionConfig {

	    @Autowired
	    private EntityManagerFactory emf;

	    @Bean
	    public PlatformTransactionManager transactionManager() {
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	      return transactionManager;
	    }    
	  }
	  
}
