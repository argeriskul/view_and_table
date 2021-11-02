package com.example.view_and_table;

import com.example.view_and_table.data.mysql.OfficeRepository;
import com.example.view_and_table.model.mysql.Office;
import com.example.view_and_table.model.postgre.City;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = OfficeRepository.class,
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef =  "mysqlTransactionManager"
)
public class MySqlConfiguration {

    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties(prefix="spring.datasource2")
    public DataSource anotherDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean mySqlEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDatasource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages(Office.class)
                .build();
    }

    @Bean(name = "mysqlTransactionManager")
    public JpaTransactionManager postgreTransactionManager(
            @Qualifier("mysqlEntityManager") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
