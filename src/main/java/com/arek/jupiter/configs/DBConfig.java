package com.arek.jupiter.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:credentials.properties")
public class DBConfig {

    @Bean
    public DataSource getDataSource(final DBConfigProperties dbConfigProperties) {
        return DataSourceBuilder.create()
                .driverClassName(dbConfigProperties.getDriver())
                .url(dbConfigProperties.getUrl())
                .username(dbConfigProperties.getUser())
                .password(dbConfigProperties.getPassword())
                .build();
    }

}
