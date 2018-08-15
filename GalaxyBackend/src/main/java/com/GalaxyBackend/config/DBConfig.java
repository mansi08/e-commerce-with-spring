package com.GalaxyBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.GalaxyBackend")
@EnableTransactionManagement


public class DBConfig {
	private final String Driver = "org.h2.Driver";
	private final String DBURL = "jdbc:h2:tcp://localhost/~/GalaxyBackend";
	private final String DBUsername = "galaxy";
	private final String DBPassword = "galaxy";
	private final String DBDialect = "org.hibernate.dialect.H2Dialect"; // from hibernate jar folder

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Driver);
		dataSource.setUrl(DBURL);
		dataSource.setUsername(DBUsername);
		dataSource.setPassword(DBPassword);
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(dataSource);
		lsfb.addProperties(getHibernateProperties());
		lsfb.scanPackages("com.GalaxyBackend");
		return lsfb.buildSessionFactory();
	}

	@SuppressWarnings("unused")
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", DBDialect);
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
}
