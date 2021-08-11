package com.arek.jupiter.configs;

import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
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
