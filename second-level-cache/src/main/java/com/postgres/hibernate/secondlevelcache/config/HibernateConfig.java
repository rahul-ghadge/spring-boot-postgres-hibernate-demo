package com.postgres.hibernate.secondlevelcache.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Resource
	public org.springframework.core.env.Environment env;

	
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setConnectionProperties(getConnectionProperties());
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

//	private static Properties getConnectionProperties() {
//
//		Properties properties = new Properties();
//		properties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//		properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
//		properties.setProperty("spring.jpa.properties.hibernate.show_sql", "true");
//		properties.setProperty("spring.jpa.properties.hibernate.format_sql", "true");
//		properties.setProperty("spring.jpa.properties.hibernate.use_sql_comments", "true");
//		properties.setProperty("spring.jpa.properties.hibernate.cache.use_second_level_cache", "true");
//		properties.setProperty("spring.jpa.properties.hibernate.cache.use_query_cache", "true");
//		properties.setProperty("spring.jpa.properties.hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//		properties.setProperty("spring.jpa.properties.javax.persistence.sharedCache.mode", "ALL");
//
//		return properties;
//	}
	
	
	private Properties getJPAProperties() {

		Properties properties = new Properties();
		
		properties.setProperty(Environment.DIALECT, env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.setProperty(Environment.HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.setProperty(Environment.SHOW_SQL, env.getProperty("spring.jpa.properties.hibernate.show_sql"));
		properties.setProperty(Environment.FORMAT_SQL, env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.setProperty(Environment.USE_SQL_COMMENTS, env.getProperty("spring.jpa.properties.hibernate.use_sql_comments"));
		properties.setProperty(Environment.USE_SECOND_LEVEL_CACHE, env.getProperty("spring.jpa.properties.hibernate.cache.use_second_level_cache"));
		properties.setProperty(Environment.USE_QUERY_CACHE, env.getProperty("spring.jpa.properties.hibernate.cache.use_query_cache"));
		properties.setProperty(Environment.CACHE_REGION_FACTORY, env.getProperty("spring.jpa.properties.hibernate.cache.region.factory_class"));
		properties.setProperty(Environment.JPA_SHARED_CACHE_MODE, env.getProperty("spring.jpa.properties.javax.persistence.sharedCache.mode"));
		
		
		
//		properties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//		properties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
//		properties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, "true");
//		properties.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, "true");
//		properties.setProperty(org.hibernate.cfg.Environment.USE_SQL_COMMENTS, "true");
//		properties.setProperty(org.hibernate.cfg.Environment.USE_SECOND_LEVEL_CACHE, "true");
//		properties.setProperty(org.hibernate.cfg.Environment.USE_QUERY_CACHE, "true");
//		properties.setProperty(org.hibernate.cfg.Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//		properties.setProperty("spring.jpa.properties.javax.persistence.sharedCache.mode", "ALL");

		return properties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.postgres.hibernate.entities" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		em.setJpaProperties(getJPAProperties());

		return em;
	}

}
