package com.example.view_and_table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

@SpringBootApplication
public class ViewAndTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewAndTableApplication.class, args);
	}


}
