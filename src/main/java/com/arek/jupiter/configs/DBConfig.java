package com.arek.jupiter.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:credentials.properties")
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("jdbc.driver"))
                .url(env.getProperty("jdbc.url"))
                .username(env.getProperty("jdbc.user"))
                .password(env.getProperty("jdbc.password"))
                .build();
    }

}
