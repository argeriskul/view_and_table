package com.example.view_and_table;

import com.example.view_and_table.data.postgre.CityRepository;
import com.example.view_and_table.model.mysql.Office;
import com.example.view_and_table.model.postgre.City;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        /** вместо разделения по пакетам можно использовать
         * excludeFilters = @ComponentScan.Filter(OfficeRepository.class)
         * но пакеты лучше */
        basePackageClasses = CityRepository.class,
        entityManagerFactoryRef = "postgreEntityManager",
        transactionManagerRef = "postgreTransactionManager"
)
public class PostgreConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource1")
    public DataSource postgreDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgreEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean postgreEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgreDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages(City.class)
                .build();
    }

    @Bean(name = "postgreTransactionManager")
    @Primary
    public JpaTransactionManager postgreTransactionManager(
            @Qualifier("postgreEntityManager") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
