package com.jankkol.fodmap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@ComponentScan("com.jankkol.fodmap")
@PropertySource(value = "classpath:/application.properties")
@PropertySource(value = "classpath:/db.properties")
@EnableTransactionManagement
public class FodmapConfiguration {

    private final Environment env;

    @Autowired
    public FodmapConfiguration(Environment env) {this.env = env;}

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource(env));
        em.setPackagesToScan(new String[] {"com.jankkol.fodmap"});
        em.setJpaProperties(hibernateProperties());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    @Autowired
    public DataSource dataSource(Environment env) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("fodmap.db.driver"));
        dataSource.setUrl(env.getProperty("fodmap.db.url"));
        dataSource.setUsername(env.getProperty("fodmap.db.username"));
        dataSource.setPassword(env.getProperty("fodmap.db.password"));
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(DIALECT, env.getProperty("org.hibernate.dialect"));
        hibernateProperties.setProperty(STATEMENT_BATCH_SIZE, env.getProperty("hibernate.jdbc.batch_size"));
        hibernateProperties.setProperty(HBM2DDL_AUTO, "none");
        hibernateProperties.setProperty(ENABLE_SYNONYMS, "true");
        return hibernateProperties;
    }
}
